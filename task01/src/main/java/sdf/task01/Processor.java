package sdf.task01;

public class Processor {

    private String[] terms;
    private String firstName;
    private String address;
    private String years;
    private String letter;
    private String[] addressTerms;
    private String newAddress;

    public Processor() {
    }

    public String writeLetter(String dataInput) {
        this.terms = dataInput.split(",");
        this.firstName = terms[0];
        this.address = terms[2];
        this.years = terms[3];

        this.newAddress = "";
        this.addressTerms = address.split("\\\\n");

        for (int i = 0; i < addressTerms.length; i++) {
            this.newAddress = this.newAddress + addressTerms[i] + "\n";
        }

        this.letter = String.format("%s \nDear %s, \n\nThank you for staying with us over these %s years. \n\n", this.newAddress, this.firstName, this.years);

        return this.letter;
    }

}