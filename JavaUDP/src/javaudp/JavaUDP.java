/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaudp;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class JavaUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        // TODO code application logic here
        try {
            InetAddress ia = InetAddress.getByName("10.10.10.2");
            int port = 1987;
            Scanner s = new Scanner(System.in);
            System.out.println("Masukkan Pesan = ");
            String pesan = s.nextLine();
                byte[] data = pesan.getBytes();
                DatagramPacket dp = new DatagramPacket(data,data.length,ia,port);
                DatagramSocket ds = new DatagramSocket();
                ds.send(dp);
                System.out.println(pesan);
        } catch (Exception e) {
        }
    } 
}
