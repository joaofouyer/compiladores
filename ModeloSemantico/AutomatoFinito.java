import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class AutomatoFinito{
    public String inicial;
    public List<String> terminalList;
    public Map<String, Transicao> regraMap;
    public boolean aceitou;
    
    public AutomatoFinito(){
        terminalList = new ArrayList<>();
        regraMap = new HashMap<>();
    }
    
    public void iniciar(){
        inicial = "q0";
        terminalList.add("q0");
        terminalList.add("q1");

        Transicao r = new Transicao();
        r.iniciar("r1", "q0", 'a', "q1");
        regraMap.put(r.nome, r);
    }
    
    public boolean reconheceu(){
        return aceitou;
    }

    public void processar(String w){
        String q = inicial;
        aceitou = false;
        int k = w.length();
        int reconhecidos = 0;
        for (Character s : w.toCharArray()){
            for (Transicao r : regraMap.values()){
                if (r.habilitada(q, s)){
                    q = r.destino;
                    reconhecidos++;
                    break;
                }
            }
        }
        aceitou = reconhecidos == k && terminalList.contains(q);
    }

    public static void main(String[] args){
        String w = "aa";
        AutomatoFinito a = new AutomatoFinito();
        a.iniciar();
        a.processar(w);
        System.out.println(a.reconheceu());
    }
}
