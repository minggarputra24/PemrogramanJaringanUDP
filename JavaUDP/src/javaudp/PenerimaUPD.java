/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaudp;

import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author ASUS
 */
public class PenerimaUPD {
    public static void main(String[] args) {
        try {
            byte[] buffer = new byte[65];
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            DatagramSocket ds = new DatagramSocket(1987);
            ds.receive(dp);
            byte[] data = dp.getData();
            String pesan = new String(data,0,data.length);
            System.out.println("Pesan dari teman anda adalah = " + pesan);
        } catch (Exception e) {
        }
    }
}
