/*
    Classe que gerencia o placar e vários dados
    Nome: Ana Laura Chioca Vieira
    NUSP: 9866531
 */

public class Bozo {
    public static void main (String[] args) throws Exception {
        Placar p = new Placar();
        System.out.println("*** BEM VINDO AO BOZÓ! ***");
        RolaDados d = new RolaDados(5);
        int dados[] = new int[5];

        // Repete 10 vezes -> 10 rodadas.
        for (int i = 0; i < 10; i++){
            System.out.println("\nPressione ENTER para iniciar a rodada #" + (i+1) + ":");
            EntradaTeclado.leString();

            dados = d.rolar();
            System.out.println(d.toString());

            // o jogador pode escolher quais dados rolar novamente 2x
            for (int j = 0; j < 2; j++) {
                System.out.println("Quais dados deseja rolar novamente? Caso não quiser trocar nenhum dado pressione ENTER.");
                while (true) {
                    try {
                        String str = EntradaTeclado.leString();
                        if (str.isEmpty()) break;
                        dados = d.rolar(str);
                        break;
                    } catch (NumberFormatException e) { // entrada inválida
                        System.out.println("Entrada inválida, digite novamente: ");
                    }
                }
                System.out.println(d.toString());
            }

            String str = p.toString();
            System.out.println(str);

            // Seleciona qual posição do placar será ocupada por rodada
            System.out.println("Qual posição deseja ocupar??");
            while (true) {
                try {
                    int pos = EntradaTeclado.leInt();
                    p.add(pos, dados);
                    break;
                } catch (NumberFormatException e) { // entrada inválida
                    System.out.println("Entrada inválida, digite novamente: ");
                }
            }

            System.out.println("Placar atualizado:\n");
            str = p.toString();
            System.out.println(str);
        }

        // Ao fim de todas as rodadas, mostra a pontuação final
        System.out.println("\nPontuação final: " + p.getScore());

    }
}
