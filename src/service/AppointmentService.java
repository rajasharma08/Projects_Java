package service;

import model.Appointment;
import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentService {

    private ArrayList<Appointment> appointments = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    PatientService patientService;
    DoctorService doctorService;


    public AppointmentService(PatientService patientService,
                              DoctorService doctorService) {

        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    public void bookAppointment(){
        System.out.println("Enter the patient id : ");
        int patientId = scanner.nextInt();

        Patient patient = patientService.searchPatientById(patientId);

        if(patient==null){
            System.out.println("Patient not found");
            return;
        }

        System.out.println("Enter the doctor id : ");
        int doctorId = scanner.nextInt();

        Doctor doctor = doctorService.searchPatientById(doctorId);

        if(doctor == null){
            System.out.println("Doctor not found");
            return;
        }

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        System.out.println("Enter Appointment Date : ");
        String appointmentDate = scanner.next();

        appointment.setAppointmentDate(appointmentDate);

        appointments.add(appointment);
        System.out.println("Appointment date booked successfully!!!");
        System.out.println(appointments);

    }

    public void viewAppointment(){
        if(appointments.isEmpty()){
            System.out.println("No Appointment are present");
            return;
        }
        for(Appointment appointment : appointments){
            System.out.println(appointments);
        }

    }

}
