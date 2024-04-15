package sistemaamigosecreto;

public class MensagemParaAlguem {

    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima){

    }

    public String getEmailDestinatario(){
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario){
        this.emailDestinatario = emailDestinatario;
    }

    public String getTextoCompletoAExibir(){
        return textoCompletoAExibir;
    }
}
