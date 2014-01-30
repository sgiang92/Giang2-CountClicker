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

	public CounterModel get(int index) {
		return counterList.get(index);
	}
	

}
