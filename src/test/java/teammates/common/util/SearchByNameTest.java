package teammates.common.util;

import org.junit.Test;
import teammates.storage.entity.Account;
import teammates.test.BaseTestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchByNameTest extends BaseTestCase {
    @Test
    public void testPesquisarUsuarioPorNome_Exato() {
        // Arrange: Criar uma lista de usuários fictícia com um usuário específico
        List<Account> usuarios = Arrays.asList(
                new Account("João", "joao@example.com"),
                new Account("Maria", "maria@example.com"),
                new Account("Pedro", "pedro@example.com")
        );

        // Act: Realizar a pesquisa por nome exato
        SearchByName searchByName = new SearchByName();
        List<Account> resultado = searchByName.pesquisarPorNome(usuarios, "Maria");

        // Assert: Verificar se o resultado contém o usuário esperado
        assertEquals(1, resultado.size());
        assertEquals("Maria", resultado.get(0).getName());
        assertEquals("maria@example.com", resultado.get(0).getEmail());
    }

    @Test
    public void testPesquisarUsuarioPorNome_Parte() {
        // Arrange: Criar uma lista de usuários fictícia com nomes diferentes
        List<Account> usuarios = new ArrayList<>();
        usuarios.add(new Account("João Silva", "joao@example.com"));
        usuarios.add(new Account("Maria Santos", "maria@example.com"));
        usuarios.add(new Account("Pedro Alves", "pedro@example.com"));

        // Act: Realizar a pesquisa por parte do nome
        SearchByName searchByName = new SearchByName();
        List<Account> result = searchByName.pesquisarPorNome(usuarios, "San");

        // Assert: Verificar se o resultado contém os usuários esperados
        assertEquals(1, result.size());
        assertEquals("Maria Santos", result.get(0).getName());
        assertEquals("maria@example.com", result.get(0).getEmail());
    }

    @Test
    public void testPesquisarUsuarioPorNome_Inexistente() {
        // Arrange: Criar uma lista de usuários fictícia com nomes diferentes
        List<Account> usuarios = new ArrayList<>();
        usuarios.add(new Account("João Silva", "joao@example.com"));
        usuarios.add(new Account("Maria Santos", "maria@example.com"));
        usuarios.add(new Account("Pedro Alves", "pedro@example.com"));

        // Act: Realizar a pesquisa por um nome inexistente
        SearchByName searchByName = new SearchByName();
        List<Account> resultado = searchByName.pesquisarPorNome(usuarios, "José");

        // Assert: Verificar se o resultado está vazio
        assertEquals(0, resultado.size());
    }
}
