package sdf.task01;

public class Processor {

    private String[] terms;
    private String firstName;
    private String lastName;
    private String address;
    private String years;
    private String letter;
    private String[] addressTerms;
    private String newAddress;

    public Processor() {
    }

    public void sortData(String dataInput) {
        this.terms = dataInput.split(",");
        this.firstName = terms[0];
        this.lastName = terms[1];
        this.address = terms[2];
        this.years = terms[3];
    }

}