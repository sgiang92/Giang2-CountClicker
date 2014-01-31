package ca.ualberta.cs.giang2_countclicker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CounterActivity extends Activity {
	private TextView counterNameTitle;
	private TextView counterCount;
	private CounterModel counter;
	private int counterPosition;
	private String counterType = "CounterModel";
	private EditText renameText;

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
		
		Button renameButton = (Button) findViewById(R.id.renameCounter);
		renameText = (EditText) findViewById(R.id.renameTextBody);
		renameButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				counter.setName(renameText.getText().toString());
				counterNameTitle.setText(counter.getName());
				renameText.setText("");

			}
		});
		
		Button resetButton  = (Button) findViewById(R.id.resetCounter);
		resetButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				//http://www.askingbox.com/tip/android-programming-yes-no-dialog-box
				AlertDialog.Builder builder = new AlertDialog.Builder(CounterActivity.this);
				 
				builder.setTitle("Reset Counter");
				builder.setMessage("Do you want to rest this counter?");
				 
				 
				builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				 
				   @Override
				   public void onClick(DialogInterface dialog, int which) {
				         
				        // Code that is executed when clicking YES
					   	String oldname = counter.getName();
						counter = new CounterModel(oldname);
						counterCount.setText(Integer.toString(counter.getCount()));	
				        
				   }
				 
				});
				 
				 
				builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
				 
				   @Override
				   public void onClick(DialogInterface dialog, int which) {
				 
				        // Code that is executed when clicking NO
					   
				        dialog.dismiss();
				   }
				 
				});
				 
				 
				AlertDialog alert = builder.create();
				alert.show();
					

			}
		});
		
		Button deleteButton = (Button) findViewById(R.id.deleteCounter);
		deleteButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//http://www.askingbox.com/tip/android-programming-yes-no-dialog-box
				AlertDialog.Builder builder = new AlertDialog.Builder(CounterActivity.this);
				 
				builder.setTitle("Delete Counter");
				builder.setMessage("Do you want to delete this Counter?");
				 
				 
				builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				 
				   @Override
				   public void onClick(DialogInterface dialog, int which) {
				         
				        // Code that is executed when clicking YES
						counterType = "DeleteCounter";
						finish();
				        
				   }
				 
				});
				 
				 
				builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
				 
				   @Override
				   public void onClick(DialogInterface dialog, int which) {
				 
				        // Code that is executed when clicking NO
					   
				        dialog.dismiss();
				   }
				 
				});
				 
				 
				AlertDialog alert = builder.create();
				alert.show();
				
			}
		});
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		
		Intent intent = new Intent(CounterActivity.this, MainActivity.class);
		Bundle bundle = new Bundle();
		bundle.putSerializable(counterType, counter);
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
