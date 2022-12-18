/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eirvid;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Muhammad Ali
 */
public class Rental {

    int id; //this will be auto incremented in database
    int movieId;
    int userId;    
    java.util.Date rentedAt = new Date();
    java.sql.Date sqlDate;
    Date willReturnAt;
  
    public Rental(int _movieId, int _userId, int _willReturnAfter) throws ParseException {        
        
        
        this.movieId = _movieId;
        this.userId = _userId;        
        Calendar c = Calendar.getInstance();
        c.setTime(this.rentedAt);
        c.add(Calendar.DATE, _willReturnAfter);
        this.willReturnAt = c.getTime();        
        this.rentedAt = new java.sql.Date(rentedAt.getTime());
        this.willReturnAt = new java.sql.Date(willReturnAt.getTime());
       
        //we have not added Id as it will be a primary key which is auto incremented by db.
        //we have not added rentedAt as it will automatically be added when an object is created.
        
    }

    @Override
    public String toString() {
        return this.movieId + " has been rented by " + this.userId + " at: " + this.rentedAt;
    }

}
