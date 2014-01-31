/*
 * SingleCountModel
 * Written By Steven Giang
 * A model for a Single Count. Holds when the date the count was
 * added to a counter. 
 * For the use of statistics, each count must have its own date.
 * Made Serializable so it can be passed along with the counter
 */
package ca.ualberta.cs.giang2_countclicker;

import java.io.Serializable;
import java.util.Date;

public class SingleCountModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private Date countDate;

	public SingleCountModel() {
		super();
		countDate = new Date();
	}

	public Date getCountDate() {
		return countDate;
	}
	
	

	
	

}
