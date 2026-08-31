package service;

import model.Patient;
import repository.PatientRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class PatientService {

    private ArrayList<Patient> patients;

    private PatientRepository patientRepository =
            new PatientRepository();

    Scanner scanner = new Scanner(System.in);


    // Load patients from file when PatientService is created
    public PatientService() {
        patients = patientRepository.getAllPatients();
    }


    // ADD PATIENT
    public void addPatient() {

        Patient patient = new Patient();

        System.out.println("Enter Patient Id : ");
        int patientId = scanner.nextInt();

        // Check duplicate patient ID
        for (Patient p : patients) {

            if (p.getPatientId() == patientId) {

                System.out.println(
                        "Patient details are already present with this patient id."
                );

                return;
            }
        }

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


        // Add patient to ArrayList
        patients.add(patient);

        // Save patient to file
        patientRepository.savePatient(patient);

        System.out.println("Patient details added successfully.");
        System.out.println(patient);
    }


    // VIEW PATIENTS
    public void viewPatients() {

        if (patients.isEmpty()) {

            System.out.println("No Patient details are present.");

        } else {

            for (Patient patient : patients) {

                System.out.println(patient);
            }
        }
    }


    // SEARCH PATIENT BY ID - Console method
    public void searchPatientById() {

        System.out.println("Enter Patient Id:");
        int patientId = scanner.nextInt();

        boolean found = false;

        for (Patient patient : patients) {

            if (patient.getPatientId() == patientId) {

                System.out.println("Patient details found.");
                System.out.println(patient);

                found = true;
                break;
            }
        }

        if (!found) {

            System.out.println("Patient details are not present.");
        }
    }


    // SEARCH PATIENT BY ID - Used by AppointmentService
    public Patient searchPatientById(int patientId) {

        for (Patient patient : patients) {

            if (patient.getPatientId() == patientId) {

                return patient;
            }
        }

        return null;
    }


    // DELETE PATIENT
    public void deletePatientById() {

        System.out.println("Enter the patient id : ");
        int patientId = scanner.nextInt();

        boolean found = false;

        for (Patient patient : patients) {

            if (patient.getPatientId() == patientId) {

                // Remove from ArrayList
                patients.remove(patient);

                // Update file after deleting
                patientRepository.saveAllPatients(patients);

                System.out.println(
                        "Patient details deleted successfully."
                );

                found = true;
                break;
            }
        }

        if (!found) {

            System.out.println("Patient details are not present.");
        }
    }


    // UPDATE PATIENT
    public void updatepatient() {

        System.out.println("Enter patient id to update details:");
        int patientId = scanner.nextInt();

        boolean found = false;

        for (Patient patient : patients) {

            if (patient.getPatientId() == patientId) {

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


                // Save updated ArrayList to file
                patientRepository.saveAllPatients(patients);


                System.out.println(
                        "Patient details updated successfully."
                );

                System.out.println(patient);

                found = true;
                break;
            }
        }

        if (!found) {

            System.out.println(
                    "Patient details are not present."
            );
        }
    }
}