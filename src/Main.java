import model.Doctor;
import model.Patient;
import service.AppointmentService;
import service.DoctorService;
import service.PatientService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        AppointmentService appointmentService = new AppointmentService();
        Scanner scanner = new Scanner(System.in);
        try{
            while(true){
                System.out.println("Hospital Management System: ");
                System.out.println("1. Add patient");
                System.out.println("2. View patients");
                System.out.println("3. Search patient by Id");
                System.out.println("4. Delete patient by Id");
                System.out.println("5. Update patient details");
                System.out.println("6. View Doctors");
                System.out.println("7. Book Appointment");
                System.out.println("8. Exit");
                System.out.print("Enter Your Choice: ");

                int choice = scanner.nextInt();

                switch(choice){
                    case 1:
                        patientService.addPatient();
                        System.out.println();
                        break;
                    case 2:
                        patientService.viewPatients();
                        System.out.println();
                        break;
                    case 3:
                        patientService.searchPatientById();
                        System.out.println();
                        break;
                    case 4:
                        patientService.deletePatientById();
                        System.out.println();
                        break;
                    case 5:
                        // view Doctors
                    case 6:
                        // view Doctors
                    case 7:
                        // Book Appointment
                    case 8:
                        return;
                        //exit
                    default:
                        System.out.println("Enter Valid Choice!!!");
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }



    }
}