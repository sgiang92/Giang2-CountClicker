package ca.ualberta.cs.giang2_countclicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends Activity {
	private TextView counterNameTitle;
	private TextView counterCount;
	private CounterModel counter;
	private int counterPosition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter);
	}

	@Override
	protected void onResume() {
		super.onResume();

		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		if (bundle != null) {
			counter = (CounterModel) bundle.getSerializable("CounterModel");
			counterPosition = (int) bundle.getInt("position");
			

		}
		counterNameTitle = (TextView) findViewById(R.id.counterNameTitle);
		counterCount = (TextView) findViewById(R.id.counterCounts);

		counterNameTitle.setText(counter.getName());
		counterCount.setText(Integer.toString(counter.getCount()));

		Button incrementbutton = (Button) findViewById(R.id.incrementButton);
		incrementbutton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				counter.addCount();
				counterCount.setText(Integer.toString(counter.getCount()));

			}
		});

	}
	@Override
	protected void onPause(){
		super.onPause();
		
		Intent intent = new Intent(CounterActivity.this, MainActivity.class);
		Bundle bundle = new Bundle();
		bundle.putSerializable("CounterModel", counter);
		bundle.putInt("position", counterPosition);
		intent.putExtras(bundle);
		startActivity(intent);
		finish();
	}


	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.counter, menu);
		return true;
	}

}
