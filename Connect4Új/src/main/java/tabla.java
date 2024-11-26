package com.example.connect4;

public class Tabla {
    private final int sorok;
    private final int oszlopok;
    private final char[][] rács;

    public Tabla(int sorok, int oszlopok) {
        this.sorok = sorok;
        this.oszlopok = oszlopok;
        this.rács = new char[sorok][oszlopok];
        for (int i = 0; i < sorok; i++) {
            for (int j = 0; j < oszlopok; j++) {
                rács[i][j] = ' ';
            }
        }
    }

    public boolean leeresztDarab(int oszlop, char darab) {
        for (int i = sorok - 1; i >= 0; i--) {
            if (rács[i][oszlop] == ' ') {
                rács[i][oszlop] = darab;
                return true;
            }
        }
        return false;
    }

    public boolean teleVan() {
        for (int j = 0; j < oszlopok; j++) {
            if (rács[0][j] == ' ') {
                return false;
            }
        }
        return true;
    }

    public void kiirTabla() {
        for (int i = 0; i < sorok; i++) {
            for (int j = 0; j < oszlopok; j++) {
                System.out.print("| " + rács[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.print(" ");
        for (char c = 'a'; c < 'a' + oszlopok; c++) {
            System.out.print(" " + c + " ");
        }
        System.out.println();
    }

    // Nyerési feltételek
}
