package sdf.task02;

import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) {
        System.out.println("Connecting to task02.chuklee.com at port 80...");
        Socket sock = new Socket("68.183.239.26", 80);
        System.out.println("Connected.");
    }
}
