/*
Nome: Cleilson Araújo Fernandes     CPD: 43282      Semestre:3º
*/
package projeto18.pkg11;

import javax.swing.JOptionPane;

public class Projeto1811 {

    public static void main(String[] args) {
        int esc, qnt, tipo, senha=0;String nome;
        LinkedPilha lp = new LinkedPilha();
        LinkedFila lf = new LinkedFila();
        int ini = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite:\n1. Para pilha\n2. Para fila"));
        switch(ini){
            case 1:
                do{
                    esc = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite:\n1. Para adicionar processos a pilha\n2. Para executar processos da pilha\n"
                            + "3. Para consultar um dado da pilha\n4. Para mostrar todos os dados das pilhas\nQualquer outro numero para sair"));
                    switch(esc){
                        case 1:
                            qnt = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite quantos processos deseja adicionar a pilha"));
                            tipo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite qual tipo de pilha esses processos pertencem:\n"
                                    + "1. Para inscrição\n2. Para renovação\n3. Para trancamento"));
                            switch(tipo){
                                case 1:
                                    for(int i=0; i<qnt; i++){
                                        nome = JOptionPane.showInputDialog(null, "Digite o nome do aluno do processo");
                                        lp.addFirst1(nome);
                                    }
                                    break;
                                case 2:
                                    for(int i=0; i<qnt; i++){
                                        nome = JOptionPane.showInputDialog(null, "Digite o nome do aluno do processo");
                                        lp.addFirst2(nome);
                                    }
                                    break;
                                case 3:
                                    for(int i=0; i<qnt; i++){
                                        nome = JOptionPane.showInputDialog(null, "Digite o nome do aluno do processo");
                                        lp.addFirst3(nome);
                                    }
                                    break;
                            }
                            break;
                        case 2:
                            qnt = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite quantos processos deseja executar da pilha"));
                            for(int i=0; i<qnt; i++){
                                lp.executaProcesso();
                            }
                            break;
                        case 3:
                            nome = JOptionPane.showInputDialog(null, "Digito nome da pessoa do processo que deseja consultar");
                            JOptionPane.showMessageDialog(null, lp.consultaPilha(nome));
                            lp.resetaCursorP();
                            break;
                        case 4:
                            lp.retornaValores();
                            break;
                    }
                }while(esc<5 && esc>0);
                break;
            case 2:
                do{
                    esc = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite:\n1. Para entregar uma senha a(s) pessoa(s) que entram na fila\n2. Para atender pessoas da fila\n"
                            + "3. Para buscar uma senha da fila\n4. Para mostrar todas as senhas restantes\nQualquer outro numero para sair"));
                    switch(esc){
                        case 1:
                            tipo = Integer.parseInt(JOptionPane.showInputDialog(null, "A pessoa que entrou na fila é:\n"
                                    + "1. Maior de 60 anos, deficiente, gestante, etc.\n2. Aluno\n3. Professor ou Visitante"));
                            qnt = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite quantas pessoas entraram na fila"));
                            switch(tipo){
                                case 1:
                                    for(int i=0; i<qnt; i++){
                                        lf.darSenha1(senha++);
                                    }
                                    JOptionPane.showMessageDialog(null, "Senha(s) entregue(s) com sucesso!");
                                    break;
                                case 2:
                                    for(int i=0; i<qnt; i++){
                                        lf.darSenha2(senha++);
                                    }
                                    JOptionPane.showMessageDialog(null, "Senha(s) entregue(s) com sucesso!");
                                    break;
                                case 3:
                                    for(int i=0; i<qnt; i++){
                                        lf.darSenha3(senha++);
                                    }
                                    JOptionPane.showMessageDialog(null, "Senha(s) entregue(s) com sucesso!");
                                    break;
                            }
                            break;
                        case 2:
                            qnt = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite quantas pessoas da fila deseja atender"));
                            for(int i=0; i<qnt; i++){
                                lf.atenderPessoa();
                            }
                            break;
                        case 3:
                            qnt = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da senha que deseja buscar"));
                            JOptionPane.showMessageDialog(null, lf.procuraSenha(qnt));
                            lf.resetaCursorF();
                            break;
                        case 4:
                            lf.retornaSenhas();
                            break;
                    }
                }while(esc<5 && esc>0);
                break;
        }
    }
    
}
