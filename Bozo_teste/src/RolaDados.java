/*
    Classe que gerencia vários objetos Dados ao mesmo tempo.
    Nome: Ana Laura Chioca Vieira
    NUSP: 9866531
 */

public class RolaDados {

    private int nDados;
    private Dados[] dados;

    // Construtor: Cria e armazena n objetos do tipo dado
    public RolaDados(int n){
        nDados = n;
        dados = new Dados[nDados];

        for (int i = 0; i < nDados; i++){
            dados[i] = new Dados();
        }
    }

    // Rola todos os dados
    public int[] rolar() throws InterruptedException {
        int numeros[] = new int[nDados];
        for (int i = 0; i < nDados; i++){
            numeros[i] = dados[i].rolar();
            Thread.sleep(100);
        }
        return numeros;
    }

    // Le um array de booleans que indica quais dados devem ser rolados novamente
    public int[] rolar(boolean[] quais) throws InterruptedException {
        int numeros[] = new int[nDados];
        for (int i = 0; i < nDados; i++){
            if (quais[i]){
                numeros[i] = dados[i].rolar();
                Thread.sleep(100);
            }
        }
        return numeros;
    }

    // método criado para auxiliar no teste da classe
    public int[] setRolar(int a, int b, int c, int d, int e){
        int numeros[] = new int[5];
        dados[0].setLados(a);
        dados[1].setLados(b);
        dados[2].setLados(c);
        dados[3].setLados(d);
        dados[4].setLados(e);
        numeros[0] = a;
        numeros[1] = b;
        numeros[2] = c;
        numeros[3] = d;
        numeros[4] = e;

        return numeros;
    }


    // Le uma string e rola os dados indicados por ela
    public int[] rolar(java.lang.String s) throws InterruptedException {
        int numeros[] = new int[nDados];
        if (!s.isEmpty()){
            String[] str = s.split(" ");

            for (int i = 0; i < str.length; i++){
                int dado = Integer.parseInt(str[i]);
                Thread.sleep(100);
                dados[dado-1].rolar();
            }
        }

        for (int j = 0; j < nDados; j++){
            numeros[j] = dados[j].getLado();
        }

        return numeros;
    }

    /*
    Pega a string de cada dado jogado e constroi uma nova string,
    colocando as representações dos dados lado a lado.
     */
    @Override
    public String toString(){
        String horizontal = "";
        String[][] str = new String[nDados][5];

        for (int i = 0; i < nDados; i++){
            str[i] = dados[i].toString().split("\\n");
        }

        for (int i = 0; i < nDados; i++){
            horizontal += (i + 1) + "        ";
        }

        horizontal += "\n";

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < nDados; j++){
                horizontal += str[j][i] + "  ";
            }
            horizontal += "\n";
        }
        return horizontal;
    }

    // Método para testar a classe
//    public static void main(String[] args) throws InterruptedException {
//        RolaDados rd = new RolaDados(5);
//
//        rd.rolar();
//        System.out.println(rd);
//
//        rd.rolar("1 4 5");
//        System.out.println(rd);
//
//        boolean[] b = new boolean[] {true, false, false, true, false};
//        rd.rolar(b);
//        System.out.println(rd);
//    }
}
