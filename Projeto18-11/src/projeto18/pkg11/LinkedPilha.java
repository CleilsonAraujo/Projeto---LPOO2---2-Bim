package projeto18.pkg11;

import javax.swing.JOptionPane;

public class LinkedPilha {
    int size1, size2, size3, prio1, prio2;
    NodePilha1 first1, cursor1;
    NodePilha2 first2, cursor2;
    NodePilha3 first3, cursor3;
    
    public void addFirst1(String insc){
        first1 = new NodePilha1(insc, first1);
        size1++;
    }
    public void addFirst2(String insc){
        first2 = new NodePilha2(insc, first2);
        size2++;
    }
    public void addFirst3(String insc){
        first3 = new NodePilha3(insc, first3);
        size3++;
    }
    public void executaProcesso(){
        if(size1==0 && size2==0 && size3==0){
            JOptionPane.showMessageDialog(null, "Não há processos na pilha");
        }
        if(prio1<2 && size1!=0){
            first1=first1.next;
            size1--;
            prio1++;
        }else{
            if(prio2<2 && size2!=0){
                first2=first2.next;
                size2--;
                prio2++;
                prio1=0;
            }else{
                if(size3!=0){
                    first3=first3.next;
                    size3--;
                    prio1=0;
                    prio2=0;
                }else{
                    prio1=0;
                    prio2=0;
                }
            }
        }
    }
    public void retornaValores(){
	NodePilha1 cursor1=first1;
        System.out.println("Pilha 1:");
        while (cursor1!=null){
            System.out.println(cursor1.inscricao);
            cursor1 = cursor1.next;
        }
        System.out.println("Pilha 2:");
        NodePilha2 cursor2=first2;
        while (cursor2!=null){
            System.out.println(cursor2.renovacao);
            cursor2 = cursor2.next;
        }
        System.out.println("Pilha 3:");
        NodePilha3 cursor3=first3;
        while (cursor3!=null){
            System.out.println(cursor3.trancamento);
            cursor3 = cursor3.next;
        }
    }
    public String consulta1(String nome, int index){
        if (index==-1){
            return "1º pilha está vazia\n";
        }
        if(cursor1.inscricao.equals(nome)){
            return nome+" encontrado(a) na 1º pilha\n";
        }
        if (index==0){
            return "Esse nome não foi encontrado na 1º pilha\n";
        }
        cursor1=cursor1.next;
        return consulta1(nome, index-1);
    }
    public String consulta2(String nome, int index){
        if (index==-1){
            return "2º pilha está vazia\n";
        }
        if(cursor2.renovacao.equals(nome)){
            return nome+" encontrado(a) na 2º pilha\n";
        }
        if (index==0){
            return "Esse nome não foi encontrado na 2º pilha\n";
        }
        cursor2=cursor2.next;
        return consulta2(nome, index-1);
    }
    public String consulta3(String nome, int index){
        if (index==-1){
            return "3º pilha está vazia";
        }
        if(cursor3.trancamento.equals(nome)){
            return nome+" encontrado(a) na 3º pilha";
        }
        if (index==0){
            return "Esse nome não foi encontrado na 3º pilha";
        }
        cursor3=cursor3.next;
        return consulta3(nome, index-1);
    }
    public String consultaPilha(String nome){
        cursor1=first1;
        cursor2=first2;
        cursor3=first3;
        int index1=size1-1;
        int index2=size2-1;
        int index3=size3-1;
        return consulta1(nome, index1)+consulta2(nome, index2)+consulta3(nome, index3);
    }
    public void resetaCursorP(){
        cursor1=null;
        cursor2=null;
        cursor3=null;
    }
}
