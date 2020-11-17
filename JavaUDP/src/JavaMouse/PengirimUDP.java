/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMouse;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author ASUS
 */
public class PengirimUDP {
    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getByName("10.10.10.2");
            int port = 2022;
//          posisi kursor
            PointerInfo a;
            Point b;
            int x;
            int y;
            while (true) {   
                a = MouseInfo.getPointerInfo();
                b = a.getLocation();
                x = (int) b.getX();
                y = (int) b.getY();
                String pesanX = String.valueOf(x);
                String pesanY = String.valueOf(y);

                String pesan = pesanX + "|" + pesanY + "|";
                byte[] data = pesan.getBytes();
                DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);
                DatagramSocket ds = new DatagramSocket();
                Thread.sleep(50);
                ds.send(dp);
            }
            
        } catch (Exception e) {
        }
    }
}
