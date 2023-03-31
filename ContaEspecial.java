public class ContaEspecial extends ContaBancaria {
    private double limite;

    
    public ContaEspecial(String nomeCliente, int numeroConta, double saldo, double limite) {
        super(nomeCliente, numeroConta, saldo);
        this.limite = limite;
    }

    
    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public boolean saca(double valor) {
        if (getSaldo() - valor >= -limite) {
            setSaldo(getSaldo() - valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
        return false;
    }


    public boolean sacaComLimite(double valor) {
        return false;
    }
}