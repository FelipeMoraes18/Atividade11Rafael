import java.util.Calendar;

public class ContaPoupanca extends ContaBancaria {
    private int diaRendimento;

    
    public ContaPoupanca(String nomeCliente, int numeroConta, double saldo, ContaPoupanca contaPoupanca) {
        super(nomeCliente, numeroConta, saldo);
        contaPoupanca.diaRendimento = diaRendimento;
    }

    
    public int getDiaRendimento() {
        return diaRendimento;
    }

    public void setDiaRendimento(int diaRendimento) {
        this.diaRendimento = diaRendimento;
    }

    
    public void atualiza(double taxa) {
        if (diaRendimento == Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) {
            setSaldo(getSaldo() + (getSaldo() * taxa));
        }
    }
}