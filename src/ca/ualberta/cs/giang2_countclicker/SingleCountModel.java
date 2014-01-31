/*
 * SingleCountModel
 * Written By Steven Giang
 * A model for a Single Count. Holds when the date the count was
 * added to a counter. 
 * For the use of statistics, each count must have its own date.
 * Made Serializable so it can be passed along with the counter
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
