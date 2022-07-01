package sdf.task02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        String response;
        String[] responseTerms;
        String requestId;
        float averageOfIntegers;

        System.out.println("Connecting to task02.chuklee.com at port 80...");
        Socket sock = new Socket("task02.chuklee.com", 80);
        System.out.println("Connected.");

        OutputStream os = sock.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        ObjectOutputStream oos = new ObjectOutputStream(dos);

        InputStream is = sock.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        ObjectInputStream ois = new ObjectInputStream(dis);

        Calculator calculator = new Calculator();
        response = ois.readUTF();
        responseTerms = response.split(" ");
        requestId = responseTerms[0];
        averageOfIntegers = calculator.calculateAverage(responseTerms[1]);
        System.out.println(averageOfIntegers);

        oos.writeUTF(requestId);
        oos.flush();
        oos.writeUTF("KokSiang");
        oos.flush();
        oos.writeUTF("wcks095@gmail.com");
        oos.flush();
        oos.writeFloat(averageOfIntegers);
        oos.flush();

        boolean newResponse = ois.readBoolean();
        if (newResponse) {
            System.out.println("SUCCESS");
        } else {
            String errorMessage = ois.readUTF();
            System.out.println(errorMessage);
            System.out.println("FAILED");
        }

        dis.close();
        is.close();
        dos.close();
        os.close();
    }
}
