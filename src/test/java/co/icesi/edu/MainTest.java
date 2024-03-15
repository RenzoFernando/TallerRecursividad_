package co.icesi.edu;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class MainTest {

    @Test
    public void testReverseString() {
        String input = "Abecedario";
        String expected = "oiradecebA";
        assertEquals(expected, Main.reverseString(input));
    }

    @Test
    public void testProm() {
        int[] array = {1, 2, 3, 4, 5, 6};
        double expected = 3.5;
        assertEquals(expected, Main.prom(array), 0.001);
    }

    @Test
    public void testDivisionEntera() {
        int dividendo = 20;
        int divisor = 3;
        Main.divisionEntera(dividendo, divisor);
    }

    @Test
    public void testEuclidesMCD() {
        int a = 48;
        int b = 18;
        int expected = 6;
        assertEquals(expected, Main.euclidesMCD(a, b));
    }

    @Test
    public void testCambioDinero() {
        int TARGET = 82500;
        List<Integer> cambio = Main.cambioDinero(TARGET);

        int sumaCambio = cambio.stream().mapToInt(Integer::intValue).sum();
        assertEquals(TARGET, sumaCambio);
    }
}
