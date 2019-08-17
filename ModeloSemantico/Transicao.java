
public class Transicao{
    public String nome;
    String origem;
    Character simbolo;
    public String destino;

    public Transicao(){
        
    }

    public void iniciar(String r, String p, Character s, String q){
        nome = r;
        origem = p;
        simbolo = s;
        destino = q;
    }

    public boolean habilitada(String q, char s){
    	return q.equals(origem) && s == simbolo;
    }
}
