import java.util.Scanner;

public class PrimeiroVetor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[10];

       
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            vetor[i] = sc.nextInt();  
        }

        boolean vetorOrdenado = true;
        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i] > vetor[i + 1]) {
                vetorOrdenado = false;
                break;
            }
        }

        if (vetorOrdenado) {
            System.out.println("O vetor está ordenado.");
        } else {
            System.out.println("O vetor não está ordenado.");
        }

       
        boolean continuar = true;
        while (continuar) {
            System.out.print("Digite um elemento a ser encontrado: ");
            int elemento = sc.nextInt();
            int posicao;

            if (vetorOrdenado) {
                posicao = buscaBinaria(vetor, elemento);
                if (posicao != -1) {
                    System.out.println("Elemento encontrado na posição: " + posicao);
                } else {
                    System.out.println("Elemento não encontrado.");
                }
            } else {
                System.out.println("O vetor não está ordenado. Não é possível realizar busca binária.");
            }

          
            System.out.print("Deseja continuar? (s/n): ");
            char resposta = sc.next().charAt(0);
            continuar = (resposta == 's' || resposta == 'S');
        }

       
        sc.close();
    }

    
    public static int buscaBinaria(int[] vetor, int elemento) {
        int esquerda = 0;
        int direita = vetor.length - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;

            if (vetor[meio] == elemento) {
                return meio; 
            } else if (vetor[meio] < elemento) {
                esquerda = meio + 1; 
            } else {
                direita = meio - 1; 
            }
        }

        return -1; 
    }
}

