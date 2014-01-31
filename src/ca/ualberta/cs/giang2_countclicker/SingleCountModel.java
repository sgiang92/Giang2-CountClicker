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
