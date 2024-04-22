package sistemaamigosecreto;

public class Mensagem {
    private String texto;
    private String emailRemetente;
    public String emailDestinatario;
    boolean anonima;

    public Mensagem(String texto, String emailRemetente, String emailDestinatario, boolean anonima){
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.anonima = anonima;
        this.emailDestinatario = emailDestinatario;

    }

    public String getTexto(){
        return texto;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    public String getTextoCompletoAExibir(){
        return textoCompletoAExibir;
    }

    public String getEmailRemetente(){
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente){
        this.emailRemetente = emailRemetente;
    }

    public boolean ehAnonima(){
        return anonima;
    }
}
