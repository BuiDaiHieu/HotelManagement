package models;

public class Customer {
    private long idCustomer;
    private String citizenIdentificationCard;
    private int age;
    private String phoneNumber;

    public Customer() {
    }

    public Customer(String citizenIdentificationCard, int age, String phoneNumber) {
        this.citizenIdentificationCard = citizenIdentificationCard;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCitizenIdentificationCard() {
        return citizenIdentificationCard;
    }

    public void setCitizenIdentificationCard(String citizenIdentificationCard) {
        this.citizenIdentificationCard = citizenIdentificationCard;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-30s%-30s%-18s", getIdCustomer(), getCitizenIdentificationCard(), getAge(), getPhoneNumber());
    }
}
