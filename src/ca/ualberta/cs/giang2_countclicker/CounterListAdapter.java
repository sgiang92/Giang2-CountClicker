/*
 * CounterListAdapter
 * Edited by Steven Giang
 * 
 * Used a template from the following websites
 * http://stackoverflow.com/questions/2265661/how-to-use-arrayadaptermyclass
 * http://www.ezzylearning.com/tutorial.aspx?tid=1763429
 * 
 * This a ArrayAdapter that is written to display the counters to the listView.
 	This file is part of Giang2-CountClicker.

   	Giang2-CountClicker is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Giang2-CountClicker is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Giang2-CountClicker.  If not, see <http://www.gnu.org/licenses/>.
 */
package ca.ualberta.cs.giang2_countclicker;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
