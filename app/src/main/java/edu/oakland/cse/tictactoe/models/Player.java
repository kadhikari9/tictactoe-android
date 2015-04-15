package edu.oakland.cse.tictactoe.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by kusu on 4/14/15.
 */
public class Player implements Serializable{

    private String firstname="";
    private String lastname="";
    private boolean isComputer;

    public Player(String first, String last) {
        this.firstname=first;
        this.lastname=last;
    }

    public boolean isComputer(){
        return isComputer;
    }

    public void setIsComputer(boolean isComputer){
        this.isComputer=isComputer;
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(firstname);
        dest.writeString(lastname);
        dest.writeString(Boolean.toString(isComputer));
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
