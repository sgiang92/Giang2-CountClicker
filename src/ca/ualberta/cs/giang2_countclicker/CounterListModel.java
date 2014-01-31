/*
 * CounterListModel
 * Written By Steven Giang
 * 
 * Model for a counter List
 * Holds a list of counters. 
 * 
 *  This file is part of Giang2-CountClicker.

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

public class CounterListModel {

	private ArrayList<CounterModel> counterList;

	public CounterListModel() {
		super();
		counterList = new ArrayList<CounterModel>();
	}

	public ArrayList<CounterModel> getCounterList() {
		return counterList;
	}
	

	public void setCounterList(ArrayList<CounterModel> counterList) {
		this.counterList = counterList;
	}

	public void addNewCounter(String name) {
		counterList.add(new CounterModel(name));
	}
	
	public void addOldCounter(CounterModel counter){
		counterList.add(counter);
	}

	public int arraySize() {
		return counterList.size();
	}

	public void removeCounter(int index) {
		counterList.remove(index);
	}

	//returns a counter that is in the list at a specific index
	public CounterModel get(int index) {
		return counterList.get(index);
	}
	
	//modify the information of a counter at a specific index
	public void modCounter(int index,CounterModel counter){
		counterList.set(index, counter);
	}
	

}
