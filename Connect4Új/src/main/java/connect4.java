package com.example.connect4;

import java.util.Random;
import java.util.Scanner;

public class ConnectFour {
    private final Tabla tabla;
    private char aktuálisJátékos;

    public ConnectFour(int sorok, int oszlopok) {
        this.tabla = new Tabla(sorok, oszlopok);
        this.aktuálisJátékos = 'Y'; // Sárga kezd
    }

    public void játssz() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            tabla.kiirTabla();

            int oszlop;
            if (aktuálisJátékos == 'Y') {
                System.out.print("Válassz egy oszlopot (a-g): ");
                String bemenet = scanner.nextLine();
                oszlop = bemenet.charAt(0) - 'a';
            } else {
                oszlop = random.nextInt(tabla.getOszlopok());
                System.out.println("A gép lépése: " + (char) ('a' + oszlop));
            }

            if (tabla.leeresztDarab(oszlop, aktuálisJátékos)) {
                if (ellenőrizNyert()) {
                    tabla.kiirTabla();
                    System.out.println("A nyertes: " + aktuálisJátékos);
                    break;
                }
                if (tabla.teleVan()) {
                    tabla.kiirTabla();
                    System.out.println("Döntetlen!");
                    break;
                }
                váltJátékost();
            } else {
                System.out.println("Érvénytelen lépés, próbáld újra.");
            }
        }
    }

    private void váltJátékost() {
        aktuálisJátékos = (aktuálisJátékos == 'Y') ? 'R' : 'Y';
    }

    private boolean ellenőrizNyert() {
        // Ellenőrző metódusok (horizontálisan, vertikálisan, átlósan) itt
        return false; // Visszatérítendő érték
    }

    public static void main(String[] args) {
        ConnectFour játék = new ConnectFour(6, 7);
        játék.játssz();
    }
}
