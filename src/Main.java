import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        eleicao eleicao = new eleicao();

        while (true) {
            System.out.println("1. Adicionar Candidato");
            System.out.println("2. Votar");
            System.out.println("3. Salvar Dados");
            System.out.println("4. Mostrar Resultados");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = 0;
            boolean entradaValida = false;
            while (!entradaValida) {
                try {
                    opcao = scanner.nextInt();
                    scanner.nextLine(); 
                    entradaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número.");
                    scanner.nextLine(); 
                    System.out.print("Escolha uma opção: ");
                }
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Candidato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Partido do Candidato: ");
                    String partido = scanner.nextLine();
                    eleicao.adicionarCandidato(new candidato(nome, partido));
                    break;
                case 2:
                    System.out.print("Nome do Candidato a votar: ");
                    String nomeCandidato = scanner.nextLine();
                    eleicao.votar(nomeCandidato);
                    break;
                case 3:
                    System.out.print("Nome do arquivo para salvar: ");
                    String nomeArquivo = scanner.nextLine();
                    eleicao.salvarDados(nomeArquivo);
                    break;
                case 4:
                    eleicao.mostrarResultados();
                    break;
                case 5:
                    scanner.close();
                    System.out.println("Encerrando o sistema.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
