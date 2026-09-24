/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;
import java.util.Scanner;
            
/**
 *
 * @author LOQ
 */

public class Validasi {
 
    public int bacaInt(Scanner input, String label) {
        while (true) {
            System.out.print(label);
            if (input.hasNextInt()) {
                int nilai = input.nextInt();
                input.nextLine();
                return nilai;
            } else {
                System.out.println("Input harus berupa angka bulat, coba lagi.");
                input.nextLine();
            }
        }
    }
 
    public double bacaDouble(Scanner input, String label) {
        while (true) {
            System.out.print(label);
            if (input.hasNextDouble()) {
                double nilai = input.nextDouble();
                input.nextLine();
                return nilai;
            } else {
                System.out.println("Input harus berupa angka, coba lagi.");
                input.nextLine();
            }
        }
    }
}
