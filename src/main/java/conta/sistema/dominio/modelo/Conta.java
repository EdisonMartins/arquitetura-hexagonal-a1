package conta.sistema.dominio.modelo;

import java.math.BigDecimal;

import static conta.sistema.dominio.modelo.Erro.obrigatorio;
import static conta.sistema.dominio.modelo.Erro.saldoInsuficiente;
import static java.util.Objects.isNull;

public class Conta {
    private Integer numero;
    private BigDecimal saldo;
    private String correntista;

    public Conta() {
        numero = 0;
        saldo = BigDecimal.ZERO;
        correntista = "não informado";
    }

    public Conta(Integer numero, BigDecimal saldo, String correntista) {
        this.numero = numero;
        this.saldo = saldo;
        this.correntista = correntista;
    }

    public void creditar(BigDecimal credito) {
        if (isNull(credito)) {
            obrigatorio("Valor crédito");
        }
        if (credito.compareTo(BigDecimal.ZERO) <= 0) {
            obrigatorio("Valor crédito");
        }
        saldo = saldo.add(credito);
    }

    public void debitar(BigDecimal debito) {
        if (isNull(debito)) {
            obrigatorio("Valor débito");
        }
        if (debito.compareTo(BigDecimal.ZERO) <= 0) {
            obrigatorio("Valor débito");
        }
        if (debito.compareTo(saldo) > 0) {
            saldoInsuficiente();
        }
        saldo = saldo.subtract(debito);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                ", correntista='" + correntista + '\'' +
                '}';
    }

    // Getters and Setters
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public String getCorrentista() {
        return correntista;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void setCorrentista(String correntista) {
        this.correntista = correntista;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta = (Conta) o;

        return numero.equals(conta.numero);
    }

    @Override
    public int hashCode() {
        return numero.hashCode();
    }


}