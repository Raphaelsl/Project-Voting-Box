import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Eleicao eleicao = new Eleicao();
    Scanner sc = new Scanner(System.in);

    // Uso do try-catch para lidar com erros de entrada do usuário
    try {
      configurarEleicao(eleicao, sc);
      iniciarVotacao(eleicao, sc);
      eleicao.exibirRelatorioFinal();
    } catch (Exception e) {
      System.out.println("Erro inesperado: " + e.getMessage());
    } finally {
      sc.close(); // Sempre fechar o scanner pra não vazar memória
    }
  }

  private static void configurarEleicao(Eleicao eleicao, Scanner sc) {
    System.out.println("==========.: CONFIGURANDO ELEIÇÃO :.==========");
    System.out.print("Quantos cargos teremos? ");
    int qtd = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < qtd; i++) {
      System.out.print("Nome do cargo (ex: CDICEA): ");
      Cargo c = new Cargo(sc.nextLine());

      System.out.print("Quantos candidatos para este cargo? ");
      int n = Integer.parseInt(sc.nextLine());

      for (int j = 0; j < n; j++) {
        System.out.print("Número do candidato: ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.print("Nome do candidato: ");
        String nome = sc.nextLine();
        c.adicionarCandidato(new Candidato(num, nome));
      }
      eleicao.addCargo(c);
    }
  }

  private static void iniciarVotacao(Eleicao eleicao, Scanner sc) {
    while (true) {
      System.out.println("\n--- NOVO ELEITOR ---");
      boolean todos999 = true; // Flag pro encerramento consecutivo

      for (Cargo cargo : eleicao.getCargos()) {
        System.out.println("\nVotando para: " + cargo.getNome());
        System.out.print("Número, 'BRANCO' ou '999': ");
        String entrada = sc.nextLine().trim().toUpperCase();

        if (!entrada.equals("999")) {
          todos999 = false; // Se um cargo não for 999, não encerra a urna
          processarVoto(cargo, entrada, sc);
        }
      }

      if (todos999) {
        System.out.println("\n[SISTEMA] Encerrando votação por 999 consecutivo...");
        break;
      }
    }
  }

  private static void processarVoto(Cargo cargo, String entrada, Scanner sc) {
    if (entrada.equals("BRANCO")) {
      System.out.print("Voto BRANCO. CONFIRMA? (S/N): ");
      if (sc.nextLine().equalsIgnoreCase("S")) cargo.registrarVotoBranco();
    } else {
      try {
        int num = Integer.parseInt(entrada);
        Candidato cand = cargo.buscarCandidato(num);
        if (cand != null) {
          System.out.print("Candidato: " + cand.getNome() + ". CONFIRMA? (S/N): ");
          if (sc.nextLine().equalsIgnoreCase("S")) cand.registrarVoto();
        } else {
          System.out.print("Número não encontrado. Votar NULO? (S/N): ");
          if (sc.nextLine().equalsIgnoreCase("S")) cargo.registrarVotoNulo();
        }
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida! Digite apenas números ou BRANCO.");
      }
    }
  }
}