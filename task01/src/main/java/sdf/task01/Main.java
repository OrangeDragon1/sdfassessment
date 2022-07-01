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
        String dataInput = args[0];
        String dataOutput = args[1];

        Processor processor = new Processor();

        Reader r = new FileReader(dataInput);
        BufferedReader br = new BufferedReader(r);
        Writer w = new FileWriter(dataOutput);
        BufferedWriter bw = new BufferedWriter(w);

        // remove first line
        String data = br.readLine();

        while (null != data) {
            data = br.readLine();
            if (null != data) {
                String letter = processor.writeLetter(data);
                System.out.println(letter);
                bw.write(letter);
            }
        }
        br.close();
        bw.close();
    }
}
