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

        if (resultados.isEmpty()) {
            Account usuarioInexistente = new Account("Usuário Inexistente", "");
            resultados.add(usuarioInexistente);
        }

        return resultados;
    }
}
