package sistemaamigosecreto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class SistemaAmigoMapTest {
    private SistemaAmigoMap sistema;

    @Before
    public void setUp() {
        sistema = new SistemaAmigoMap();
    }

    @Test
    public void testCadastraAmigo() {
        sistema.cadastraAmigo("João", "joao@example.com");
        Amigo amigo = sistema.pesquisaAmigo("joao@example.com");
        assertEquals("João", amigo.getNome());
    }

    @Test
    public void testPesquisaAmigoInexistente() {
        Amigo amigo = sistema.pesquisaAmigo("inexistente@example.com");
        assertNull(amigo);
    }

    @Test
    public void testEnviarMensagemParaTodos() {
        sistema.cadastraAmigo("João", "joao@example.com");
        sistema.cadastraAmigo("Maria", "maria@example.com");

        sistema.enviarMensagemParaTodos("Olá, pessoal!", "joao@example.com", false);
        sistema.enviarMensagemParaTodos("Olá, pessoal!", "maria@example.com", true);

        assertEquals(2, sistema.pesquisaTodasAsMensagens().size());
        assertEquals(1, sistema.pesquisaMensagensAnonimas().size());
    }

    @Test
    public void testConfiguraAmigoSecretoDe() {
        sistema.cadastraAmigo("João", "joao@example.com");
        sistema.cadastraAmigo("Maria", "maria@example.com");

        sistema.configuraAmigoSecretoDe("joao@example.com", "maria@example.com");

        assertEquals("maria@example.com", sistema.pesquisaAmigoSecretoDe("joao@example.com"));
    }

    @Test
    public void testPesquisaAmigoSecretoDeInexistente() {
        assertNull(sistema.pesquisaAmigoSecretoDe("inexistente@example.com"));
    }

    @Test
    public void testEnviarMensagemParaAlguem() {
        sistema.cadastraAmigo("João", "joao@example.com");
        sistema.cadastraAmigo("Maria", "maria@example.com");

        sistema.enviarMensagemParaAlguem("Olá, Maria!", "joao@example.com", "maria@example.com", false);

        assertEquals(1, sistema.pesquisaTodasAsMensagens().size());
        assertEquals("Olá, Maria!", sistema.pesquisaTodasAsMensagens().get(0).getTexto());
    }

    @Test
    public void testPesquisaMensagensAnonimasSemMensagensAnonimas() {
        sistema.cadastraAmigo("João", "joao@example.com");
        sistema.enviarMensagemParaTodos("Olá, pessoal!", "joao@example.com", false);

        assertEquals(0, sistema.pesquisaMensagensAnonimas().size());
    }

    @Test
    public void testPesquisaTodasAsMensagensSemMensagens() {
        assertEquals(0, sistema.pesquisaTodasAsMensagens().size());
    }
}

