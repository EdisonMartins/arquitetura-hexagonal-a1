package hexagon.ports.out;

import hexagon.domain.model.conta.Conta;

public interface ContaRepositorio {
    Conta get(Integer numero);
    void alterar(Conta conta);
}
