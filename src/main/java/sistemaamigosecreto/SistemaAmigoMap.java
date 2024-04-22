package sistemaamigosecreto;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class SistemaAmigoMap {
    private Map<String, Amigo> amigos;

    public SistemaAmigoMap() {
        this.amigos = new HashMap<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo){
        Amigo novoAmigo = new Amigo(nomeAmigo, emailAmigo);
        amigos.put(emailAmigo, novoAmigo);
    }

    public Amigo pesquisaAmigo(String emailAmigo){
        return amigos.get(emailAmigo);
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        for (Amigo amigo : amigos.values()) {
            enviarMensagem(texto, emailRemetente, amigo.getEmail(), ehAnonima);
        }
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        enviarMensagem(texto, emailRemetente, emailDestinatario, ehAnonima);
    }

    private void enviarMensagem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        Mensagem mensagem;
        if (ehAnonima) {
            mensagem = new Mensagem(texto, emailRemetente, true);
        } else {
            mensagem = new Mensagem(texto, emailRemetente, emailDestinatario, false);
        }
    }

    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for (Amigo amigo : amigos.values()) {
            for (Mensagem mensagem : amigo.getMensagens()) {
                if (mensagem.isAnonima()) {
                    mensagensAnonimas.add(mensagem);
                }
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens(){
        List<Mensagem> todasAsMensagens = new ArrayList<>();
        for (Amigo amigo : amigos.values()) {
            todasAsMensagens.addAll(amigo.getMensagens());
        }
        return todasAsMensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado){
        Amigo pessoa = amigos.get(emailDaPessoa);
        pessoa.setAmigoSecreto(emailAmigoSorteado);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa){
        Amigo pessoa = amigos.get(emailDaPessoa);
        return pessoa.getAmigoSecreto();
    }
}

