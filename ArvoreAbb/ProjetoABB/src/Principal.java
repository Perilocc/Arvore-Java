import java.util.Scanner;

public class Principal {
	static Scanner entrada = new Scanner(System.in);
	static NoArvore raiz = null;
    public static void main(String[] args) {
        
        
        boolean sair = false;

        while (!sair) {
            System.out.println("\n==============MENU==============\n");
            System.out.println("1-Inserir um aluno na Árvore Binária de Busca.");
            System.out.println("2-Imprimir Árvore Binária de Busca.");
            System.out.println("3-Buscar um aluno na Árvore Binária de Busca");
            System.out.println("4-Remover um aluno na Árvore Binária de Busca");
            System.out.println("5-Sair");
            System.out.println("==================================");
            System.out.println("Digite o número da ação desejada: ");
            int escolha = entrada.nextInt();

            switch (escolha) {
                case 1:
                	entrada.nextLine();
                    System.out.println("\nDigite o nome do aluno: ");
                    String nome = entrada.nextLine();
                    System.out.println("\nDigite o RGM do aluno: ");
                    int rgm = entrada.nextInt();
                    
                    Aluno novoAluno = new Aluno(nome, rgm);
                    raiz = NoArvore.insere(raiz, novoAluno);
                    break;

                case 2:
                	MenuImpressões();
                	break;
                	// Implementar lógica para opções de impressão: Pré, In e Pós
                	// Ou faz if's ou faz uma função com if's
                	
                case 3:
                    System.out.println("\nDigite o RGM a ser buscado na árvore:");
                    int rgmBuscado = entrada.nextInt();
                    NoArvore resultadoBusca = NoArvore.busca(raiz, rgmBuscado);

                    if (resultadoBusca == null) {
                        System.out.println("\nAluno com RGM " + rgmBuscado + " não encontrado.");
                    } 
                    
                    else {
                        System.out.println("\nAluno com RGM " + resultadoBusca.aluno.rgm + " encontrado. Nome: " + resultadoBusca.aluno.nome);
                    }
                    break;

                case 4:
                    System.out.println("\nDigite o RGM do aluno a ser removido: ");
                    int rgmRemover = entrada.nextInt();
                    raiz = NoArvore.remove(raiz, rgmRemover);
                    break;

                case 5:
                    System.out.println("\nObrigado por utilizar a aplicação!!!");
                    System.exit(0);

                default:
                    System.out.println("\nOpção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        }
    }

	private static void MenuImpressões() {
		
		System.out.println("\nEscolha a forma da Impressão:");
    	System.out.println("1-Impressão Pré Ordem ");
    	System.out.println("2-Impressão In-Ordem ");
    	System.out.println("3-Impressão Pós Ordem ");
    	System.out.println("4-Voltar para o Menu");
    	System.out.println("==================================");
        System.out.println("Digite o número da ação desejada:");
        int opcao = entrada.nextInt();
        
        switch(opcao) {
        	
        	case 1:
        		System.out.println("\nImpressão Pré Ordenada:");
            	NoArvore.imprimePreOrdem(raiz);
                break;
            
        	case 2:
        		System.out.println("\nImpressão In-Ordem:");
            	NoArvore.imprimeInOrdem(raiz);
                break;
            
        	case 3:
        		System.out.println("\nImpressão Pós Ordenada:");
            	NoArvore.imprimePosOrdem(raiz);
                break;
                
        	case 4:
        		System.out.println("Retornando para o Menu da aplicação ...");
        		break;
        		
            default:
            	System.out.println("\nOpção inválida. Por favor, digite uma opção válida na próxima vez");
                break;
        }
		
	}
}
