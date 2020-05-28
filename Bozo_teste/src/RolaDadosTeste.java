import org.junit.Test;

import static org.junit.Assert.*;

public class RolaDadosTeste {

    @Test
    public void rolar() {
    }

    @Test
    public void testRolar() throws InterruptedException {
        RolaDados dados = new RolaDados(5);
        int numeros[] = new int[5];
        numeros = dados.rolar();
        int count = 0;

        // testa se todos os dados sorteados estão entre 1 e 6
        for (int i = 0; i < 5; i++){
            if (numeros[i] >= 1 && numeros[i] <= 6) count++;
        }

        assertEquals(5, count);

    }

    @Test
    public void testRolar1() throws InterruptedException {
        RolaDados dados = new RolaDados(5);

        int numeros[] = new int[5];
        int rolar[] = new int[5];
        numeros = dados.setRolar(-1,-1,-1,-1,-1);
        boolean quais[] = {true, true, false, true, false};
        rolar = dados.rolar(quais);
        int count = 0;

        for (int j = 0; j < 5; j++){
            if (quais[j]){
                numeros[j] = rolar[j];
            }
        }

        // testa se apenas os dados escolhidos foram rolados novamente
        for (int i = 0; i < 5; i++){
            if (numeros[i] != -1) count++;
        }

        assertEquals(3, count);
    }

    @Test
    public void testRolar2() throws InterruptedException {
        RolaDados dados = new RolaDados(5);

        int numeros[] = new int[5];
        int rolar[] = new int[5];
        numeros = dados.setRolar(-1,-1,-1,-1,-1);
        String quais = "3 4 5";
        rolar = dados.rolar(quais);
        int count = 0;

        numeros[2] = rolar[2];
        numeros[3] = rolar[3];
        numeros[4] = rolar[4];

        // testa se apenas os dados escolhidos foram rolados novamente
        for (int i = 0; i < 5; i++){
            if (numeros[i] != -1) count++;
        }

        assertEquals(3, count);
    }

    @Test
    public void testToString1() {
        RolaDados dados = new RolaDados(5);
        dados.setRolar(2, 3, 4, 6, 1);

        String str = "1        2        3        4        5        \n" +
                "+-----+  +-----+  +-----+  +-----+  +-----+  \n" +
                "| *   |  | *   |  | * * |  | * * |  |     |  \n" +
                "|     |  |  *  |  |     |  | * * |  |  *  |  \n" +
                "|   * |  |   * |  | * * |  | * * |  |     |  \n" +
                "+-----+  +-----+  +-----+  +-----+  +-----+  \n";

        assertEquals(str, dados.toString());
    }

    @Test
    public void testToString2() {
        RolaDados dados = new RolaDados(5);
        dados.setRolar(3, 6, 4, 5, 1);

        String str = "1        2        3        4        5        \n" +
                "+-----+  +-----+  +-----+  +-----+  +-----+  \n" +
                "| *   |  | * * |  | * * |  | * * |  |     |  \n" +
                "|  *  |  | * * |  |     |  |  *  |  |  *  |  \n" +
                "|   * |  | * * |  | * * |  | * * |  |     |  \n" +
                "+-----+  +-----+  +-----+  +-----+  +-----+  \n";

        assertEquals(str, dados.toString());
    }

    @Test
    public void main() {
        // Trata-se de um método criado para testar a classe
    }
}