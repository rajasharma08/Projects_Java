package model;

public class Patient {

    private int patientId;
    private String patientName;
    private int age;
    private Long mobileNo;
    private String address;
    private String disease;

    public Patient(){}

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Patient(int patientId, String patientName, int age, Long mobileNo, String address, String disease){
        this.patientId = patientId;
        this.patientName= patientName;
        this.age= age;
        this.mobileNo=mobileNo;
        this.address=address;
        this.disease=disease;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", age=" + age +
                ", mobileNo=" + mobileNo +
                ", address='" + address + '\'' +
                ", disease='" + disease + '\'' +
                '}';
    }
}
