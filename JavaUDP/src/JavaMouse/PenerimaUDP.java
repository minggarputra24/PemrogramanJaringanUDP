/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMouse;

import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author ASUS
 */
public class PenerimaUDP {
    public static void main(String[] args) {
        try {
            byte[] buffer = new byte[65];
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            DatagramSocket ds = new DatagramSocket(2022);
            Robot rb = new Robot();
            while (true) {                
                ds.receive(dp);
                byte[] data = dp.getData();
                String pesan = new String(data, 0, data.length);
                System.out.println("Pesan dari teman Anda : "+pesan);
                // 100|200|
                String[] posisi = pesan.split("\\|");
                int x= Integer.parseInt(posisi[0]);
                int y= Integer.parseInt(posisi[1]);
                
                rb.mouseMove(x, y); //300, 500
                rb.delay(5);
                rb.mousePress(MouseEvent.BUTTON1_MASK);
//                Thread.sleep(50);
                rb.mouseRelease(MouseEvent.BUTTON1_MASK);
            }
        } catch (Exception e) {
        }
    }
}
