package projeto18.pkg11;

import javax.swing.JOptionPane;

public class LinkedFila{
    private NodeFila1 first1, last1, cursor1;
    private NodeFila2 first2, last2, cursor2;
    private NodeFila3 first3, last3, cursor3;
    private int size1, size2, size3, prio1, prio2;

    public void atenderPessoa(){
	if(size1==0 && size2==0 && size3==0){
            JOptionPane.showMessageDialog(null, "Não há pessoas em fila");
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
    public void darSenha1(int senha){
	NodeFila1 ult = new NodeFila1(senha, null);
            if(size1==0){
		last1=ult;
		first1=last1;
            }else{
		last1.next=ult;
		last1=ult;
            }
            size1++;
    }
    public void darSenha2(int senha){
	NodeFila2 ult = new NodeFila2(senha, null);
            if(size2==0){
		last2=ult;
		first2=last2;
            }else{
		last2.next=ult;
		last2=ult;
            }
            size2++;
    }
    public void darSenha3(int senha){
	NodeFila3 ult = new NodeFila3(senha, null);
            if(size3==0){
		last3=ult;
		first3=last3;
            }else{
		last3.next=ult;
		last3=ult;
            }
            size3++;
    }
    public void retornaSenhas(){
	NodeFila1 cursor1=first1;
        System.out.println("Senhas de prioridade 1:");
        while (cursor1!=null){
            System.out.println(cursor1.senha);
            cursor1 = cursor1.next;
        }
        System.out.println("Senhas de prioridade 2:");
        NodeFila2 cursor2=first2;
        while (cursor2!=null){
            System.out.println(cursor2.senha);
            cursor2 = cursor2.next;
        }
        System.out.println("Senhas de prioridade 3:");
        NodeFila3 cursor3=first3;
        while (cursor3!=null){
            System.out.println(cursor3.senha);
            cursor3 = cursor3.next;
        }
    }
    public String procuraSenha1(int senha, int index){
        if (index==-1){
            return "Fila de prioridade 1 está vazia\n";
        }
        if(senha==cursor1.senha){
            return "Senha "+senha+" encontrada na fila de prioridade 1\n";
        }
        if (index==0){
            return "Senha não encontrada na fila 1\n";
        }
        cursor1=cursor1.next;
        return procuraSenha1(senha, index-1);
    }
    public String procuraSenha2(int senha, int index){
        if (index==-1){
            return "Fila de prioridade 2 está vazia\n";
        }
        if(senha==cursor2.senha){
            return "Senha "+senha+" encontrada na fila de prioridade 2\n";
        }
        if (index==0){
            return "Senha não encontrada na fila 2\n";
        }
        cursor2=cursor2.next;
        return procuraSenha2(senha, index-1);
    }
    public String procuraSenha3(int senha, int index){
        if (index==-1){
            return "Fila de prioridade 3 está vazia";
        }
        if(senha==cursor3.senha){
            return "Senha "+senha+" encontrada na fila de prioridade 3";
        }
        if (index==0){
            return "Senha não encontrada na fila 3";
        }
        cursor3=cursor3.next;
        return procuraSenha3(senha, index-1);
    }
    public String procuraSenha(int senha){
        cursor1=first1;
        cursor2=first2;
        cursor3=first3;
        int index1=size1-1;
        int index2=size2-1;
        int index3=size3-1;
        return procuraSenha1(senha, index1)+procuraSenha2(senha, index2)+procuraSenha3(senha, index3);
    }
    public void resetaCursorF(){
        cursor1=null;
        cursor2=null;
        cursor3=null;
    }
}
