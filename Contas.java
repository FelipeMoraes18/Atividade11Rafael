import java.util.ArrayList;
import java.util.Scanner;

public class Contas {
    
    static ArrayList<ContaBancaria> contas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("Menu de opções:");
            System.out.println("a) Incluir nova conta");
            System.out.println("b) Sacar valor de uma conta");
            System.out.println("c) Depositar valor em uma conta");
            System.out.println("d) Atualizar valor de todas as contas poupança");
            System.out.println("e) Mostrar saldo de todas as contas");
            System.out.println("f) Sair");
            System.out.println("Escolha uma opção: ");
            
            String opcao = scanner.next();
            
            switch (opcao) {
                case "a":
                    incluirConta();
                    break;
                case "b":
                    sacarValor();
                    break;
                case "c":
                    depositarValor();
                    break;
                case "d":
                    atualizarPoupancas();
                    break;
                case "e":
                    mostrarSaldo();
                    break;
                case "f":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    
    private static void atualizarPoupancas() {
        System.out.println("Digite a taxa de rendimento: ");
        double taxaRendimento = scanner.nextDouble();
        for (ContaBancaria conta : contas) {
            if (conta instanceof ContaPoupanca) {
                ContaPoupanca contaPoupanca = (ContaPoupanca) conta;
                contaPoupanca.atualiza(taxaRendimento);
            }
        }
        System.out.println("Contas poupança atualizadas com sucesso!");
    }

    private static void depositarValor() {
        System.out.println("Digite o número da conta: ");
        int numero = scanner.nextInt();
        System.out.println("Digite o valor a ser depositado: ");
        double valor = scanner.nextDouble();
        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numero) {
                conta.deposita(valor);
                System.out.println("Depósito realizado com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada!");
    }

    private static void mostrarSaldo() {
        for (ContaBancaria conta : contas) {
            System.out.println(conta);
        }
    }

    public static void incluirConta() {
        System.out.println("Incluir nova conta:");
        System.out.println("a) Conta bancária");
        System.out.println("b) Conta poupança");
        System.out.println("c) Conta especial");
        System.out.println("Escolha uma opção: ");
        
        String opcao = scanner.next();

        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.next();
        System.out.println("Digite o número da conta: ");
        int numero = scanner.nextInt();
        System.out.println("Digite o saldo inicial: ");
        double saldo = scanner.nextDouble();
        
        switch (opcao) {
            case "a":
                contas.add(new ContaBancaria(nome, numero, saldo));
                System.out.println("Conta bancária incluída com sucesso!");
                break;
            case "b":
                contas.add(new ContaPoupanca(nome, numero, saldo, null));
                System.out.println("Conta poupança incluída com sucesso!");
                break;
            case "c":
                System.out.println("Digite o limite de crédito: ");
                double limite = scanner.nextDouble();
                contas.add(new ContaEspecial(nome, numero, saldo, limite));
                System.out.println("Conta especial incluída com sucesso!");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
    
    
    public static void sacarValor() {
        System.out.println("Digite o número da conta: ");
        int numero = scanner.nextInt();
        System.out.println("Digite o valor a ser sacado: ");
        double valor = scanner.nextDouble();
        
        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numero) {
                if (conta instanceof ContaEspecial) {
                    ContaEspecial contaEspecial = (ContaEspecial) conta;
                    if (contaEspecial.sacaComLimite(valor)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                } else if (conta.saca(valor)) {
                    System.out.println("Saque realizado com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente!");
                }
                return;
            }
        }
        
        System.out.println("Conta não encontrada!");
     }
 }
