package teammates.common.util;

import teammates.storage.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class SearchByName {

    public List<Account> pesquisarPorNome(List<Account> usuarios, String termoPesquisa) {
        List<Account> resultados = new ArrayList<>();

        for (Account usuario : usuarios) {
            if (usuario.getName().toLowerCase().contains(termoPesquisa.toLowerCase())) {
                resultados.add(usuario);
            }
        }

        return resultados;
    }

    public int contarUsuariosPorNome(List<Account> usuarios, String termoPesquisa) {
        int contador = 0;

        for (Account usuario : usuarios) {
            if (usuario.getName().toLowerCase().contains(termoPesquisa.toLowerCase())) {
                contador++;
            }
        }

        return contador;
    }
}
