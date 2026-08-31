import service.AppointmentService;
import service.DoctorService;
import service.PatientService;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();

        AppointmentService appointmentService =
                new AppointmentService(patientService, doctorService);

        while (true) {

            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    patientMenu(patientService);
                    break;

                case 2:
                    doctorMenu(doctorService);
                    break;

                case 3:
                    appointmentMenu(appointmentService);
                    break;

                case 4:
                    System.out.println("Application Closed");
                    return;

                default:
                    System.out.println("Enter Valid Choice");
            }
        }
    }

    public static void patientMenu(PatientService patientService) {

        while (true) {

            System.out.println("\n===== Patient Management =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Back");

            System.out.print("Enter Choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    patientService.addPatient();
                    break;

                case 2:
                    patientService.viewPatients();
                    break;

                case 3:
                    patientService.searchPatientById();
                    break;

                case 4:
                    patientService.updatepatient();
                    break;

                case 5:
                    patientService.deletePatientById();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Enter Valid Choice");
            }
        }
    }

    public static void doctorMenu(DoctorService doctorService) {

        while (true) {

            System.out.println("\n===== Doctor Management =====");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Search Doctor by doctorId");
            System.out.println("4. Search Doctor by specialization");
            System.out.println("5. Delete Doctor");
            System.out.println("6. Back");

            System.out.print("Enter Choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    doctorService.addDoctor();
                    break;

                case 2:
                    doctorService.viewDoctors();
                    break;

                case 3:
                    System.out.println("Enter doctor ID");
                    int doctorId = scanner.nextInt();
                    doctorService.searchDoctorById(doctorId);
                    break;

                case 4:
                    System.out.println("Enter specialization");
                    String specialization = scanner.nextLine();
                    doctorService.searchDoctorBySpecialization(specialization);
                    break;

                case 5:
                    doctorService.deleteDoctorById();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Enter Valid Choice");
            }
        }
    }

    public static void appointmentMenu(
            AppointmentService appointmentService) {

        while (true) {

            System.out.println("\n===== Appointment Management =====");
            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Back");

            System.out.print("Enter Choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    appointmentService.bookAppointment();
                    break;

                case 2:
                    appointmentService.viewAppointments();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Enter Valid Choice");
            }
        }
    }
}