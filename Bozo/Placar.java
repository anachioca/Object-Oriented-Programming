/*
    Classe que simula um placar para o jogo Bozó.
    Nome: Ana Laura Chioca Vieira
    NUSP: 9866531
 */

import java.io.IOException;

public class Placar {

    private int placar[] = new int[10]; // guarda o placar

    // Construtor: preenche a array com -1, simbolizando que as posições estão vazias
    public Placar(){
        for (int i = 0; i < 10; i++){
            placar[i] = -1;
        }
    }

    // verifica quantos numeros da array "dados" são iguais ao número "n"
    private int dadosIguais(int n, int[] dados){
        int count = 0;
        for (int i = 0; i < dados.length; i++){
            if(dados[i] == n) count++;
        }
        return count;
    }

    // Adiciona a pontuação por posição do placar
    public void add(int posicao, int[] dados) throws IllegalArgumentException, IOException {
        boolean flag = true;

        while (flag){

            // se a posição escolhida estiver vazia:
            if (placar[posicao - 1] == -1) {
                switch (posicao) {
                    case 1:
                        placar[0] = 0;
                        for (int i = 0; i < dados.length; i++){
                            if (dados[i] == 1) placar[0] += 1;
                        }
                        flag = false;
                        break;

                    case 2:
                        placar[1] = 0;
                        for (int i = 0; i < dados.length; i++){
                            if (dados[i] == 2) placar[1] += 2;
                        }
                        flag = false;
                        break;

                    case 3:
                        placar[2] = 0;
                        for (int i = 0; i < dados.length; i++){
                            if (dados[i] == 3) placar[2] += 3;
                        }
                        flag = false;
                        break;

                    case 4:
                        placar[3] = 0;
                        for (int i = 0; i < dados.length; i++){
                            if (dados[i] == 4) placar[3] += 4;
                        }
                        flag = false;
                        break;

                    case 5:
                        placar[4] = 0;
                        for (int i = 0; i < dados.length; i++){
                            if (dados[i] == 5) placar[4] += 5;
                        }
                        flag = false;
                        break;

                    case 6:
                        placar[5] = 0;
                        for (int i = 0; i < dados.length; i++){
                            if (dados[i] == 6) placar[5] += 6;
                        }
                        flag = false;
                        break;

                    case 7: // Full Hand: 3 dados com o mesmo número, 2 com outro número
                        placar[6] = 0;
                        boolean flag2 = false;
                        boolean flag3 = false;
                        for (int i = 0; i < 6; i++) { // verifica se existem 3 numeros iguais
                            if (dadosIguais(i + 1, dados) == 3) flag3 = true;
                        }
                        for (int j = 0; j < 6; j++){ // verifica se existem 2 numeros iguais
                            if (dadosIguais(j+1, dados) == 2) flag2 = true;
                        }
                        if (flag2 && flag3) placar[6] = 15;
                        flag = false;
                        break;

                    case 8: // Sequencia: todos os dados de 2 a 6 ou todos de 1 a 5
                        placar[7] = 0;
                        int aux = 0;
                        for (int i = 0; i < 6; i++) {
                            if (dadosIguais(i + 1, dados) == 1) aux++;
                        }
                        if (aux == dados.length){ // a primeira ou a ultima posição deve estar vazia. Caso contrário uma posição intermediária estará vazia
                            if (dadosIguais(1, dados) == 0 || dadosIguais(6, dados) == 0) placar[7] = 20;
                        }
                        flag = false;
                        break;

                    case 9: // Quadra: 4 dados iguais
                        placar[8] = 0;
                        for (int i = 0; i < 6; i++){ // se 4 forem iguais a qualquer i (de 1 a 6) o placar é 30
                            if (dadosIguais(i+1, dados) == 4) placar[8] = 30;
                        }
                        flag = false;
                        break;

                    case 10: // General ou Quina: Todos os dados iguais
                        placar[9] = 0;
                        for (int i = 0; i < 6; i++){ // se todos os dados forem iguais a qualquer i (de 1 a 6) o placar é 40
                            if (dadosIguais(i+1, dados) == dados.length) placar[9] = 40;
                        }
                        flag = false;
                        break;
                }

            //caso o usuário tente ocupar uma posição já preenchida:
            } else {
                System.out.println("Posição Preenchida. Escolha outra posição: ");
                posicao = EntradaTeclado.leInt();
            }
        }

    }

    // Soma a pontuação de todas as posições do placar
    public int getScore(){
        int soma = 0;
        for (int i = 0; i < 10; i++){
            if (placar[i] != -1) {
                soma += placar[i];
            }
        }
        return soma;
    }

    // Gera uma string que representa o placar
    public java.lang.String toString(){
        String s1 = " ", s2 = " ", s3 = " ", s4 = " ", s5 = " ", s6= " ", s7 = " ", s8 = " ", s9 = " ", s10 = " ";

        if (placar[0] == -1) s1 = "(1)";
        else if (placar[0] != -1) s1 = " " + Integer.toString(placar[0]) + " ";

        if (placar[1] == -1) s2 = "(2)";
        else if (placar[1] != -1) s2 = " " + Integer.toString(placar[1]) + " ";

        if (placar[2] == -1) s3 = "(3)";
        else if (placar[2] != -1) s3 = " " + Integer.toString(placar[2]) + " ";

        if (placar[3] == -1) s4 = "(4)";
        else if (placar[3] != -1) s4 = " " + Integer.toString(placar[3]);

        if (placar[4] == -1) s5 = "(5)";
        else if (placar[4] != -1) s5 = " " + Integer.toString(placar[4]);

        if (placar[5] == -1) s6 = "(6)";
        else if (placar[5] != -1) s6 = " " + Integer.toString(placar[5]);

        if (placar[6] == -1) s7 = "(7)";
        else if (placar[6] != -1) s7 = " " + Integer.toString(placar[6]);

        if (placar[7] == -1) s8 = "(8)";
        else if (placar[7] != -1) s8 = " " + Integer.toString(placar[7]);

        if (placar[8] == -1) s9 = "(9)";
        else if (placar[8] != -1) s9 = " " + Integer.toString(placar[8]);

        if (placar[9] == -1) s10 = "(10)";
        else if (placar[9] != -1) s10 = " " + Integer.toString(placar[9]);

        String sn = s1 + "  |  " + s7 + "  |  " + s4 + "\n-------------------\n" + s2 + "  |  " + s8 + "  |  " + s5 + "\n-------------------\n" + s3 + "  |  " + s9 + "  |  " + s6 + "\n-------------------\n" + "     | " + s10 + "  |     \n     +-------+";

        return sn;
    }

}
