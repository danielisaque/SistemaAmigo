package sistemaamigosecreto;

public abstract class Mensagem {
    private String texto;
    private String emailRemetente;
    boolean anonima;

    public Mensagem(String texto, String emailRemetente, boolean anonima){

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

    }
}
