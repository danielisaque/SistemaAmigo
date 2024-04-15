package sistemaamigosecreto;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public void cadastraAmigo(String nomeAmigo, String emailAmigo){

    }

    public Amigo pesquisaAmigo(String emailAmigo){

    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){

    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){

    }

    public List<Mensagem> pesquisaMensagensAnonimas(){

    }

    public List<Mensagem> pesquisaTodasAsMensagens(){

    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado){

    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa){

    }
}
