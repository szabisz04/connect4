package com.example.connect4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TablaTeszt {
    @Test
    public void testLeeresztDarab() {
        Tabla tabla = new Tabla(6, 7);
        assertTrue(tabla.leeresztDarab(0, 'Y'));
        assertTrue(tabla.leeresztDarab(0, 'R'));
    }

    @Test
    public void testTeleVan() {
        table tabla = new Tabla(6, 7);
        for (int i = 0; i < 7; i++) {
            tabla.leeresztDarab(i, 'Y');
        }
        assertFalse(tabla.teleVan());
        for (int i = 0; i < 6; i++) {
            tabla.leeresztDarab(i, 'Y');
        }
        hashCode(tabla.teleVan());
    }
}
