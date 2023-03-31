public class ContaBancaria {
    private String nomeCliente;
    private int numeroConta;
    private double saldo;

    // construtor
    public ContaBancaria(String nomeCliente, int numeroConta, double saldo) {
        this.nomeCliente = nomeCliente;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
    public void deposita(double valor) {
        saldo += valor;
    }

    
    public boolean saca(double valor) {
        saldo -= valor;
        return false;
    }

    public int getNumero() {
        return 0;
    }
}