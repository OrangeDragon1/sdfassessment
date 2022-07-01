package sdf.task01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Main {
    public static void main(String[] args) throws IOException {
        String dataInput1 = args[0];
        String dataInput2 = args[1];
        String replaceTemplate;

        Processor processor = new Processor();

        Reader r1 = new FileReader(dataInput1);
        BufferedReader br1 = new BufferedReader(r1);
        Reader r2 = new FileReader(dataInput2);
        BufferedReader br2 = new BufferedReader(r2);

        Writer w = new FileWriter("wait a minute");
        BufferedWriter bw = new BufferedWriter(w);

        // remove first line
        String data = br1.readLine();
        while (null != data) {
            data = br1.readLine();
            if (null != data) {
                String[] dataTerms = data.split(",");
                String firstNameOrSalutations = dataTerms[0];
                String lastName = dataTerms[1];
                String addressOrPackage = dataTerms[2];
                String yearsOrPrice = dataTerms[3];
                String[] addressOrPackageTerms = addressOrPackage.split("\\\\n");
                String newAddressOrPackage = "";
                for (int i = 0; i < addressOrPackageTerms.length; i++) {
                    newAddressOrPackage = newAddressOrPackage + addressOrPackageTerms[i] + "\n";
                }

                String template = "";
                while (null != template) {
                    template = br2.readLine();
                    if (null != template) {
                        if (template.contains("_address__")) {
                            replaceTemplate = template.replace("__address__", newAddressOrPackage);
                        } else if (template.contains("__first_name__")) {
                            replaceTemplate = template.replace("__first_name__", firstNameOrSalutations);
                        } else if (template.contains("__years__")) {
                            replaceTemplate = template.replace("__years__", yearsOrPrice);
                        } else if (template.contains("__salutations__")) {
                            replaceTemplate = template.replace("__salutations__",firstNameOrSalutations);
                        } else if (template.contains("__last_name__")) {
                            replaceTemplate = template.replace("__last_name__", lastName);
                        } else if (template.contains("__package_name__")) {
                            replaceTemplate = template.replace("__package_name__", addressOrPackage);
                        } else if (template.contains("__price__")) {
                            replaceTemplate = template.replace("__price__", yearsOrPrice);
                        } else {
                            replaceTemplate = template;
                        }
                        System.out.println(replaceTemplate);
                    }
                }
            }
        }
    }
}
