package hexagon.ports.in;

import hexagon.domain.model.conta.Conta;

import java.math.BigDecimal;
/** Responsável por definir a porta de entrada (driver) de operações para caso de uso de transferência. **/
public interface PortaTransferencia {
    Conta getConta(Integer numero);
    void transferir(Integer contaDebito, Integer contaCredito, BigDecimal valor);
}
