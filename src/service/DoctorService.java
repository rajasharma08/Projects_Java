package service;

import model.Doctor;
import model.Patient;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Scanner;

public class DoctorService {

    private ArrayList<Doctor> doctors = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void addDoctor(){
        Doctor doctor = new Doctor();
        System.out.println("Enter the doctor Id : ");
        int doctorId = scanner.nextInt();
        for(Doctor d:doctors){
            if(d.getDoctorId()==doctorId){
                System.out.println("Doctor details are already present with this doctor id");
                return;
            }
        }
        doctor.setDoctorId(doctorId);
        System.out.println("Enter doctor name :");
        String doctorName = scanner.next();
        doctor.setDoctorName(doctorName);
        System.out.println("Enter doctor specialization: ");
        String specialization = scanner.next();
        doctor.setSpecialization(specialization);
        doctors.add(doctor);
        System.out.println("Doctor details added successfully!!!");
        System.out.println(doctor);
    }

    public void viewDoctors(){
        if(doctors.isEmpty()){
            System.out.println("No doctor details are present");
        }
        else{
            for(Doctor doctor : doctors){
                System.out.println(doctor);
            }
        }
    }

    public void searchDoctorById(){
        System.out.println("Enter doctor Id: ");
        int doctorId = scanner.nextInt();
        boolean found = false;
        for(Doctor doctor: doctors){
            if(doctor.getDoctorId()==doctorId){
                System.out.println(doctor);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Doctor details are not present!!!");
        }
    }

    public Doctor searchDoctorById(int doctorId){
        for(Doctor doctor:doctors){
            if(doctor.getDoctorId() == doctorId) {
                return doctor;
            }
        }
        System.out.println("Doctor details are not present!!!");
        return null;
    }

    public void deleteDoctorById(){
        System.out.println("Enter the doctor id : ");
        int doctorId = scanner.nextInt();
        boolean found = false;
        for(Doctor doctor: doctors){
            if(doctor.getDoctorId()==doctorId){
                doctors.remove(doctor);
                System.out.println("doctor details deleted successfully");
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("doctor details are not present");
        }

    }

    public Doctor searchDoctorBySpecialization(String specialization){
        for(Doctor doctor:doctors){
            if(doctor.getSpecialization() == specialization) {
                return doctor;
            }
        }
        return null;
    }


}
