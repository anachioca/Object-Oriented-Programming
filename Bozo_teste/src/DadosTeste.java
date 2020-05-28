import org.junit.Test;

import static org.junit.Assert.*;

public class DadosTeste {

    @Test
    public void rolar() {
        Dados d = new Dados();
        int k = d.rolar();
        int flag = 0;

        // testa se o numero sorteado está entre 1 e 6
        if (k >= 1 && k <= 6) flag = 1;

        assertEquals(1, flag);
    }

    @Test
    public void getLado() {
        Dados d = new Dados();
        d.setLados(3);
        int k = d.getLado();
        assertEquals(3, k);
    }

    @Test
    public void testToString1() {
        Dados d = new Dados(6);
        d.setLados(1);
        String str = "+-----+\n" +
                "|     |\n" +
                "|  *  |\n" +
                "|     |\n" +
                "+-----+\n";
        assertEquals(str, d.toString());
    }

    @Test
    public void testToString2() {
        Dados d = new Dados();
        d.setLados(2);
        String str = "+-----+\n" +
                "| *   |\n" +
                "|     |\n" +
                "|   * |\n" +
                "+-----+\n";
        assertEquals(str, d.toString());
    }

    @Test
    public void testToString3() {
        Dados d = new Dados();
        d.setLados(3);
        String str = "+-----+\n" +
                "| *   |\n" +
                "|  *  |\n" +
                "|   * |\n" +
                "+-----+\n";
        assertEquals(str, d.toString());
    }

    @Test
    public void testToString4() {
        Dados d = new Dados();
        d.setLados(4);
        String str = "+-----+\n" +
                "| * * |\n" +
                "|     |\n" +
                "| * * |\n" +
                "+-----+\n";
        assertEquals(str, d.toString());
    }

    @Test
    public void testToString5() {
        Dados d = new Dados();
        d.setLados(5);
        String str = "+-----+\n" +
                "| * * |\n" +
                "|  *  |\n" +
                "| * * |\n" +
                "+-----+\n";
        assertEquals(str, d.toString());
    }

    @Test
    public void testToString6() {
        Dados d = new Dados();
        d.setLados(6);
        String str = "+-----+\n" +
                "| * * |\n" +
                "| * * |\n" +
                "| * * |\n" +
                "+-----+\n";
        assertEquals(str, d.toString());
    }

    @Test
    public void main() {
        // trata-se de um método criado para teste
    }
}