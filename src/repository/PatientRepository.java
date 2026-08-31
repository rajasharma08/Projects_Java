package repository;

import model.Patient;

import java.io.*;
import java.util.ArrayList;

public class PatientRepository {

    private final String fileName = "patients.txt";

    // ADD
    public void savePatient(Patient patient) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(
                    patient.getPatientId() + "," +
                            patient.getPatientName() + "," +
                            patient.getAge() + "," +
                            patient.getMobileNo() + "," +
                            patient.getAddress() + "," +
                            patient.getDisease()
            );

            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error while saving patient.");
            e.printStackTrace();
        }
    }


    // READ
    public ArrayList<Patient> getAllPatients() {

        ArrayList<Patient> patients = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Patient patient = new Patient();

                patient.setPatientId(Integer.parseInt(data[0]));
                patient.setPatientName(data[1]);
                patient.setAge(Integer.parseInt(data[2]));
                patient.setMobileNo(Long.parseLong(data[3]));
                patient.setAddress(data[4]);
                patient.setDisease(data[5]);

                patients.add(patient);
            }

        } catch (FileNotFoundException e) {

            // First time application is running.
            // File doesn't exist yet.

        } catch (IOException e) {

            System.out.println("Error while reading patients.");
            e.printStackTrace();
        }

        return patients;
    }


    // UPDATE + DELETE
    public void saveAllPatients(ArrayList<Patient> patients) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(fileName))) {

            for (Patient patient : patients) {

                writer.write(
                        patient.getPatientId() + "," +
                                patient.getPatientName() + "," +
                                patient.getAge() + "," +
                                patient.getMobileNo() + "," +
                                patient.getAddress() + "," +
                                patient.getDisease()
                );

                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println("Error while updating patient file.");
            e.printStackTrace();
        }
    }
}