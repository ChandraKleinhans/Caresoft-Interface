package com.caresoft.clinicapp;
import java.util.Date;
import java.util.ArrayList;

public class Physician  extends User implements HIPAACompliantUser{
	
//... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    public Physician(Integer id) {
		super(id);
    }
    
    
    // TO DO: Implement HIPAACompliantUser!
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
    
    @Override
    public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
//    	PIN must be exactly 4 digits
		if (pin < 1000 || pin > 9999) {
			return false;
		}
		this.pin = pin;
		return true;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		// Check Physician's ID against given ID
		// Return true if there is a match and false if not.
		if (this.id == confirmedAuthID) {
			return true;
		}
		return false;
	}

//    Getters and Setters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	


}
