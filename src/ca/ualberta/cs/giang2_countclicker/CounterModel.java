/*
 * CounterModel
 * Written By Steven Giang
 * 
 * This is a model of a counter. Each counter has a name 
 * and a list of counts that is incremented when needed.
 * The Class is made Serializable so that it can be passed 
 * between activities. 
 */
package ca.ualberta.cs.giang2_countclicker;

import java.io.Serializable;
import java.util.ArrayList;

public class CounterModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	//Returns the number of counts
	public int getCount() {
		return this.countList.size();
	}
	
	//Add a new counter to the list
	public void addCount() {
		countList.add(new SingleCountModel());
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	
	
	
	
	
	

}