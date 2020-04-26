/*
    Classe que simula um dado de N lados.
    Nome: Ana Laura Chioca Vieira
    NUSP: 9866531
 */

public class Dados {
    private int lados;
    private int num;

    // Cria um dado com 6 lados
    public Dados(){
        lados = 6;
    }

    // Cria um dado com n lados
    public Dados(int n){
        lados = n;
    }

    //Rola o dado: gerador de números aleatórios de 1 até o número de lados
    public int rolar(){
        Random r = new Random();
        num = (r.getIntRand(lados) + 1);
        return num;
    }

    // Retorna o numero sorteado
    public int getLado(){
        return num;
    }

    /* Função que retorna o dado sorteado em forma de string.
    Exemplo:
    +-------+
    | *   * |
    |   *   |
    | *   * |
    +-------+
    */
    @Override
    public java.lang.String toString(){
        String dado = "+-----+\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "+-----+\n";
        if (getLado() == 1){
            dado = "+-----+\n" +
                    "|     |\n" +
                    "|  *  |\n" +
                    "|     |\n" +
                    "+-----+\n";
        }
        if (getLado() == 2){
            dado = "+-----+\n" +
                    "| *   |\n" +
                    "|     |\n" +
                    "|   * |\n" +
                    "+-----+\n";
        }
        if (getLado() == 3){
            dado = "+-----+\n" +
                    "| *   |\n" +
                    "|  *  |\n" +
                    "|   * |\n" +
                    "+-----+\n";
        }
        if (getLado() == 4){
            dado = "+-----+\n" +
                    "| * * |\n" +
                    "|     |\n" +
                    "| * * |\n" +
                    "+-----+\n";
        }
        if (getLado() == 5){
            dado = "+-----+\n" +
                    "| * * |\n" +
                    "|  *  |\n" +
                    "| * * |\n" +
                    "+-----+\n";
        }
        if (getLado() == 6){
            dado = "+-----+\n" +
                    "| * * |\n" +
                    "| * * |\n" +
                    "| * * |\n" +
                    "+-----+\n";
        }
        return dado;
    }

    //método para testar classe:
    public static void main(String[] args) {
        Dados d = new Dados();
        d.rolar();
        System.out.println(d);
    }
}
