import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlacarTeste {

    @Test
    public void add() {
        // função testada juntamente aos testes da função getScore
        // assim como a função privada "dadosIguais"
    }

    @Test
    public void getScoreVazio() {
        Placar pl = new Placar();
        int k = pl.getScore();
        assertEquals(0, k);
    }

    @Test
    public void getScoreCheio() throws Exception {
        Placar pl = new Placar();
        pl.add(1, new int[] {1, 2, 3, 4, 5} );
        pl.add(2, new int[] {1, 2, 3, 4, 5} );
        pl.add(3, new int[] {1, 2, 3, 4, 5} );
        pl.add(4, new int[] {1, 2, 3, 4, 5} );
        pl.add(5, new int[] {1, 2, 3, 4, 5} );
        pl.add(6, new int[] {1, 2, 3, 4, 5} );
        pl.add(7, new int[] {1, 2, 3, 4, 5} );
        pl.add(8, new int[] {1, 2, 3, 4, 5} );
        pl.add(9, new int[] {1, 2, 3, 4, 5} );
        pl.add(10, new int[] {1, 2, 3, 4, 5} );

        int k = pl.getScore();
        assertEquals(35, k);
    }

    // adicionar na mesma posição -> erro
    @Test (expected=Exception.class)
    public void addError() throws Exception {
        Placar pl = new Placar();
        pl.add(1, new int[] {1, 2, 3, 4, 5} );
        pl.add(1, new int[] {1, 2, 3, 4, 5} );
    }

    @Test
    public void getScoreFullHandRight() throws Exception {
        Placar pl = new Placar();
        pl.add(7, new int[] {1, 1, 1, 2, 2} );

        int k = pl.getScore();
        assertEquals(15, k);
    }

    @Test
    public void getScoreFullHandWrong() throws Exception {
        Placar pl = new Placar();
        pl.add(7, new int[] {1, 3, 1, 2, 2} );

        int k = pl.getScore();
        assertEquals(0, k);
    }

    @Test
    public void getScoreSeqRight() throws Exception {
        Placar pl = new Placar();
        pl.add(8, new int[] {1, 2, 3, 4, 5} );

        int k = pl.getScore();
        assertEquals(20, k);
    }

    @Test
    public void getScoreSeqWrong() throws Exception {
        Placar pl = new Placar();
        pl.add(8, new int[] {1, 3, 3, 4, 5} );

        int k = pl.getScore();
        assertEquals(0, k);
    }

    @Test
    public void getScoreQuadraRight() throws Exception {
        Placar pl = new Placar();
        pl.add(9, new int[] {1, 4, 4, 4, 4} );

        int k = pl.getScore();
        assertEquals(30, k);
    }

    @Test
    public void getScoreQuadraWrong() throws Exception {
        Placar pl = new Placar();
        pl.add(9, new int[] {5, 5, 4, 4, 4} );

        int k = pl.getScore();
        assertEquals(0, k);
    }

    @Test
    public void getScoreQuinaRight() throws Exception {
        Placar pl = new Placar();
        pl.add(10, new int[] {1, 1, 1, 1, 1} );

        int k = pl.getScore();
        assertEquals(40, k);
    }

    @Test
    public void getScoreQuinaWrong() throws Exception {
        Placar pl = new Placar();
        pl.add(10, new int[] {1, 2, 1, 1, 1} );

        int k = pl.getScore();
        assertEquals(0, k);
    }

    // posição inválida
    @Test (expected=Exception.class)
    public void addPosInvalid() throws Exception {
        Placar pl = new Placar();
        pl.add(12, new int[] {1, 2, 1, 1, 1} );
    }

    @Test
    public void toStringVazio() throws IOException {
        Placar pl = new Placar();

        String r = "(1)  |  (7)  |  (4)\n" +
                "-------------------\n" +
                "(2)  |  (8)  |  (5)\n" +
                "-------------------\n" +
                "(3)  |  (9)  |  (6)\n" +
                "-------------------\n" +
                "     | (10)  |     \n" +
                "     +-------+";

        assertEquals(r, pl.toString());
    }

    @Test
    public void toStringCheio() throws Exception {
        Placar pl = new Placar();
        pl.add(1, new int[] {1, 1, 1, 1, 1} );
        pl.add(2, new int[] {2, 2, 2, 2, 2} );
        pl.add(3, new int[] {3, 3, 3, 3, 3} );
        pl.add(4, new int[] {4, 4, 4, 4, 4} );
        pl.add(5, new int[] {5, 5, 5, 5, 5} );
        pl.add(6, new int[] {6, 6, 6, 6, 6} );
        pl.add(7, new int[] {1, 1, 1, 2, 2} );
        pl.add(8, new int[] {1, 2, 3, 4, 5} );
        pl.add(9, new int[] {1, 4, 4, 4, 4} );
        pl.add(10, new int[] {1, 1, 1, 1, 1} );

        String r = " 5   |   15  |   20\n" +
                "-------------------\n" +
                " 10   |   20  |   25\n" +
                "-------------------\n" +
                " 15   |   30  |   30\n" +
                "-------------------\n" +
                "     |  40  |     \n" +
                "     +-------+";

        assertEquals(r, pl.toString());
    }
}

