/*
 * CounterActivity
 * Written by Steven Giang
 * 
 * Some of the code used from the following website:
 * http://www.askingbox.com/tip/android-programming-yes-no-dialog-box
 * 
 * This android activity is in charge of handling all the operations
 * on the chosen counter from the main activity listView.
 * Some of the operations include:
 * 	-Rename - Which renames the counter
 * 	-Reset 	- Resets the counter to zero
 * 	-Delete - Delete the counter from the list.
 * 	-Summary - HAS NOT BE IMPLEMENTED YET
 */

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

		//Check if there are any information being passed from main
		//activities 
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

		//Increment the counts for the counter that is passed to Counter Activity
		Button incrementbutton = (Button) findViewById(R.id.incrementButton);
		incrementbutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				counter.addCount();
				counterCount.setText(Integer.toString(counter.getCount()));
			}
		});
		
		
		//Rename the Counter from the text that is provided by the user in the
		//EditText field
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
		
		//Reset the counter to zero
		Button resetButton  = (Button) findViewById(R.id.resetCounter);
		resetButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				/* Code for yes/no dialog box used from 
				 * - http://www.askingbox.com/tip/android-programming-yes-no-dialog-box
				 * Makes sure that user wants to reset the counter
				 */
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
		
		//Delete Counter
		Button deleteButton = (Button) findViewById(R.id.deleteCounter);
		deleteButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/* Code for yes/no dialog box used from 
				 * - http://www.askingbox.com/tip/android-programming-yes-no-dialog-box
				 * Makes sure that user wants to delete the counter
				 */
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
		/*
		 * Once the activity is put in the background,
		 * the information needed to be transfered back to the main activity
		 * will be added to a bundle.
		 */
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
