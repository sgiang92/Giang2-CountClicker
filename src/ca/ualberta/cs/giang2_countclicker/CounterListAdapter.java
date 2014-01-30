package ca.ualberta.cs.giang2_countclicker;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

//http://stackoverflow.com/questions/2265661/how-to-use-arrayadaptermyclass
//http://www.ezzylearning.com/tutorial.aspx?tid=1763429

public class CounterListAdapter extends ArrayAdapter<CounterModel> {

	private Context context;
	private int layoutResourceId;
	private ArrayList<CounterModel> items = null;

	private class CounterHolder {
		TextView counterName;
		TextView counterCount;
	}

	public CounterListAdapter(Context context, int layoutResourceId,
			ArrayList<CounterModel> items) {

		super(context, layoutResourceId, items);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.items = items;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View view = convertView;
		CounterHolder holder = null;

		if (view == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			view = inflater.inflate(layoutResourceId, parent, false);

			holder = new CounterHolder();
			holder.counterName = (TextView) view.findViewById(R.id.listRowName);
			holder.counterCount = (TextView) view
					.findViewById(R.id.listRowCount);

			view.setTag(holder);

		} else {
			holder = (CounterHolder) view.getTag();
		}

		holder.counterName.setText(items.get(position).getName());
		holder.counterCount.setText(Integer.toString(items.get(position).getCount()));

		return view;
	}

}