package service;

import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class PatientService {

    private ArrayList<Patient> patients = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void addPatient(){
        Patient patient = new Patient();
        System.out.println("Enter Patient Id : ");
        int patientId = scanner.nextInt();
        patient.setPatientId(patientId);
        System.out.println("Enter Patient Name : ");
        String patientName = scanner.next();
        patient.setPatientName(patientName);
        System.out.println("Enter Patient age : ");
        int age = scanner.nextInt();
        patient.setAge(age);
        System.out.println("Enter Patient MobileNo : ");
        Long mobileNo = scanner.nextLong();
        patient.setMobileNo(mobileNo);
        System.out.println("Enter Patient Address : ");
        String address = scanner.next();
        patient.setAddress(address);
        System.out.println("Enter Patient Disease : ");
        String disease = scanner.next();
        patient.setDisease(disease);
        patients.add(patient);
        System.out.println("patient details added successfully");
        System.out.println(patient);

    }

    public void viewPatients(){

        if(patients.isEmpty()){
            System.out.println("No Patient details are present");
        }else{
            for(Patient patient: patients){
                System.out.println(patient);
            }
        }

    }

    public void searchPatientById(){
        System.out.println("Enter Patient Id:");
        int patientId = scanner.nextInt();
        boolean found= false;
        for(Patient patient:patients){
            if(patient.getPatientId() == patientId) {
                System.out.print("Patient details found.");
                System.out.println(patient);
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Patient details are not present");
        }
    }

    public void deletePatientById(){
        System.out.println("Enter the patient id : ");
        int patientId = scanner.nextInt();
        boolean found = false;
        for(Patient patient: patients){
            if(patient.getPatientId()==patientId){
                patients.remove(patient);
                System.out.println("patient details deleted successfully");
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Patient details are not present");
        }

    }

    public void updatepatient(){
        System.out.println("Enter patient id to update details:");
        int patientId = scanner.nextInt();
        boolean found = false;
        for(Patient patient: patients){
            if(patient.getPatientId() == patientId){
                System.out.println("Enter New Patient Name:");
                String patientName = scanner.next();
                patient.setPatientName(patientName);

                System.out.println("Enter New Age:");
                int age = scanner.nextInt();
                patient.setAge(age);

                System.out.println("Enter New Mobile Number:");
                long mobileNo = scanner.nextLong();
                patient.setMobileNo(mobileNo);

                System.out.println("Enter New Address:");
                String address = scanner.next();
                patient.setAddress(address);

                System.out.println("Enter New Disease:");
                String disease = scanner.next();
                patient.setDisease(disease);

                System.out.println("Patient details updated successfully");
                System.out.println(patient);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Patient details are not present");
        }
    }

}

