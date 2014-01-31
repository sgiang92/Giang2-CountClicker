package ca.ualberta.cs.giang2_countclicker;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;

public class MainActivity extends Activity {

	private CounterListAdapter counterListAdapter;

	private CounterListModel counterList;

	private static final String FILENAME = "file.json";
	private ListView countListView;
	private EditText newCounterName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		newCounterName = (EditText) findViewById(R.id.textbody);
		Button newCounterButton = (Button) findViewById(R.id.newcounter);
		countListView = (ListView) findViewById(R.id.counterList);
		// Button counterSummary = (Button) findViewById(R.id.summary);

		newCounterButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setResult(RESULT_OK);
				counterList.addNewCounter(newCounterName.getText().toString());
				saveInFile(counterList);
				counterListAdapter.notifyDataSetChanged();
				newCounterName.setText("");

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		counterList = new CounterListModel();
		counterList = loadFromFile();
		counterListAdapter = new CounterListAdapter(this, R.layout.list_item,
				counterList.getCounterList());
		countListView.setAdapter(counterListAdapter);

	}

	@Override
	protected void onResume() {
		super.onResume();

		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		if (bundle != null) {
			CounterModel counter = (CounterModel) bundle
					.getSerializable("CounterModel");
			int counterPosition = (int) bundle.getInt("position");

			counterList.modCounter(counterPosition, counter);
			saveInFile(counterList);
			counterListAdapter.notifyDataSetChanged();
			
		}

		countListView
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						CounterModel selectedCounter = counterList
								.get(position);
						Intent intent = new Intent(MainActivity.this,
								CounterActivity.class);
						Bundle bundle = new Bundle();
						bundle.putSerializable("CounterModel", selectedCounter);
						bundle.putInt("position", position);
						intent.putExtras(bundle);
						startActivity(intent);

					}
				});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public CounterListModel loadFromFile() {
		Gson gson = new Gson();
		CounterListModel savedCounters = new CounterListModel();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);

			}
			String json = sb.toString();
			CounterListModel countersLoaded = gson.fromJson(json,
					CounterListModel.class);

			savedCounters.setCounterList(countersLoaded.getCounterList());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return savedCounters;

	}

	private void saveInFile(CounterListModel countersToSave) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			Gson gson = new Gson();
			String json = gson.toJson(countersToSave);
			fos.write(json.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
