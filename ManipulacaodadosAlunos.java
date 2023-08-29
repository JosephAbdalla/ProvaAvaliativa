import java.util.ArrayList;
import java.util.Scanner;

public class ManipulacaodadosAlunos {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Character> conceitos = new ArrayList<>();
        int[] quantidadeConceitos = new int[4];

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Inserir novo aluno e conceito");
            System.out.println("2. Listar todos os alunos e conceitos");
            System.out.println("3. Exibir quantidade de cada conceito");
            System.out.println("4. Exibir alunos com conceito mais alto");
            System.out.println("5. Encerrar o programa");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine(); 
                    System.out.print("Digite o nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o conceito (O, B, S, I): ");
                    char conceito = scanner.next().charAt(0);

                    if (conceitoIsValid(conceito)) {
                        nomes.add(nome);
                        conceitos.add(conceito);
                        updateConceitoCount(quantidadeConceitos, conceito);
                    } else {
                        System.out.println("Conceito inválido. Insira um conceito válido.");
                    }
                    break;

                case 2:
                    System.out.println("Lista de alunos e conceitos:");
                    for (int i = 0; i < nomes.size(); i++) {
                        System.out.println("Aluno: " + nomes.get(i) + " - Conceito: " + conceitos.get(i));
                    }
                    break;

                case 3:
                    System.out.println("Quantidade de cada conceito:");
                    System.out.println("O: " + quantidadeConceitos[0] + " - B: " + quantidadeConceitos[1] +
                            " - S: " + quantidadeConceitos[2] + " - I: " + quantidadeConceitos[3]);
                    break;

                case 4:
                    char conceitoMaisAlto = findHighestConceito(quantidadeConceitos);
                    System.out.println("Alunos com o conceito mais alto (" + conceitoMaisAlto + "):");
                    for (int i = 0; i < nomes.size(); i++) {
                        if (conceitos.get(i) == conceitoMaisAlto) {
                            System.out.println(nomes.get(i));
                        }
                    }
                    break;

                case 5:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
            }
        }
    }

    public static boolean conceitoIsValid(char conceito) {
        return conceito == 'O' || conceito == 'B' || conceito == 'S' || conceito == 'I';
    }

    public static void updateConceitoCount(int[] quantidadeConceitos, char conceito) {
        switch (conceito) {
            case 'O':
                quantidadeConceitos[0]++;
                break;
            case 'B':
                quantidadeConceitos[1]++;
                break;
            case 'S':
                quantidadeConceitos[2]++;
                break;
            case 'I':
                quantidadeConceitos[3]++;
                break;
        }
    }

    public static char findHighestConceito(int[] quantidadeConceitos) {
        int maxIndex = 0;
        for (int i = 1; i < quantidadeConceitos.length; i++) {
            if (quantidadeConceitos[i] > quantidadeConceitos[maxIndex]) {
                maxIndex = i;
            }
        }
        return conceitoFromIndex(maxIndex);
    }

    public static char conceitoFromIndex(int index) {
        switch (index) {
            case 0:
                return 'O';
            case 1:
                return 'B';
            case 2:
                return 'S';
            case 3:
                return 'I';
            default:
                return ' ';
        }
    }
}
