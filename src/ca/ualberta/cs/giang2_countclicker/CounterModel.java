package ca.ualberta.cs.giang2_countclicker;

import java.util.ArrayList;

public class CounterModel {
	private String name;
	private ArrayList<SingleCountModel> countList;
	
	public CounterModel(String name){
		super();
		this.name = name;
		countList = new ArrayList<SingleCountModel>();
	}

	public CounterModel( String name, ArrayList<SingleCountModel> countList) {
		super();
		this.name = name;
		this.countList = countList;
	}
	
		public ArrayList<SingleCountModel> getCountList() {
		return countList;
	}


	public void setCountList(ArrayList<SingleCountModel> countList) {
		this.countList = countList;
	}
	
	public int getCount() {
		return this.countList.size();
	}
	
	public void addCount() {
		countList.add(new SingleCountModel());
	}

	public String getName() {
		//test comment
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	
	
	
	
	
	

}