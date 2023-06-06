import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PontoAcai {

    public static void main(String[] args) {

        //cria frame/janela
        JFrame janela = new JFrame("Sistema de açai");
        janela.setSize(400, 300);
        janela.setVisible(true);
        JPanel painel = new JPanel();

        janela.getContentPane().add(painel);


        JLabel titulo = new JLabel("TAMANHO DO AÇAI:");

        //Cria as labes dos acais
        JLabel ml300 = new JLabel("AÇAI 300ml - R$10:");
        JLabel ml500 = new JLabel("AÇAI 500ml - R$15:");
        JLabel ml700 = new JLabel("AÇAI 700ml - R$20:");

        //Cria os botoes dos açais
        JButton btn300ml = new JButton("Adicionar");
        JButton btn500ml = new JButton("Adicionar");
        JButton btn700ml = new JButton("Adicionar");
        JButton btnfinalizar = new JButton("Finalizar");

        //Addiciona as labes
        painel.add(titulo);
        painel.add(ml300);
        painel.add(ml500);
        painel.add(ml700);

        //Adiciona os botões
        painel.add(btn300ml);
        painel.add(btn500ml);
        painel.add(btn700ml);
        painel.add(btnfinalizar);

        //Configura as labes
        titulo.setBounds(50, 30, 120, 50);
        ml300.setBounds(50, 60, 130, 50);
        ml500.setBounds(50, 80, 130, 50);
        ml700.setBounds(50, 100, 130, 50);

        //Configura os botões
        btn300ml.setBounds(170, 78, 90, 15);
        btn500ml.setBounds(170, 98, 90, 15);
        btn700ml.setBounds(170, 118, 90, 15);
        btnfinalizar.setBounds(120, 170, 100, 20);

        //CARRINHO

        Carrinho valor300 = new Carrinho();
        Carrinho valor500 = new Carrinho();
        Carrinho valor700 = new Carrinho();


        List<Carrinho> ca = new ArrayList();

        valor300.setValor(10.00);
        valor500.setValor(15.00);
        valor700.setValor(20.00);


        //Faz as ações dos botões

        try {

            btn300ml.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "açai 300ml adicionado com sucesso!", "Sistema de açai", JOptionPane.PLAIN_MESSAGE);
                    ca.add(valor300);
                }
            });
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel adicionar", "ocorreu um erro", JOptionPane.PLAIN_MESSAGE);
        }


        try {

            btn500ml.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "açai 500ml adicionado com sucesso!", "Sistema de açai", JOptionPane.PLAIN_MESSAGE);
                    ca.add(valor500);
                }
            });
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel adicionar", "ocorreu um erro", JOptionPane.PLAIN_MESSAGE);
        }


        try {

            btn700ml.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "açai 700ml adicionado com sucesso!", "Sistema de açai", JOptionPane.PLAIN_MESSAGE);
                    ca.add(valor700);
                }
            });
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel adicionar", "ocorreu um erro", JOptionPane.PLAIN_MESSAGE);
        }


        //Configura o botõa Finalizar

        try {

            btnfinalizar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                        String acrescimo = JOptionPane.showInputDialog(null, "Acréscimo? R$2,00", "Sistema de açai", JOptionPane.PLAIN_MESSAGE);

                        double valorTotal = 0;

                        for (int i=0; i< ca.size(); i++){
                           Carrinho c = (Carrinho) ca.get(i);
                           valorTotal += c.getValor();
                        }



                    if (acrescimo.equals("true")||acrescimo.equals("sim")){


                            valorTotal += 2;

                            JOptionPane.showMessageDialog(null, "Valor total: \n R$ " + valorTotal, "Sistema de açai", JOptionPane.PLAIN_MESSAGE);

                        BufferedWriter buffWrite = null;

                        try {
                            buffWrite = new BufferedWriter(new FileWriter("C:/Users/12116455/IdeaProjects/acai/ACAI/src/resultado.txt"));
                            buffWrite.append("O valor total do pedido foi \n"+"R$ "+String.valueOf(valorTotal));
                            buffWrite.close();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }


                    }

                        if (acrescimo.equals("false")||acrescimo.equals("não")) {

                            JOptionPane.showMessageDialog(null, "Valor total: \n R$ " + valorTotal, "Sistema de açai", JOptionPane.PLAIN_MESSAGE);

                            BufferedWriter buffWrite = null;

                            try {
                                buffWrite = new BufferedWriter(new FileWriter("C:/Users/12116455/IdeaProjects/acai/ACAI/src/resultado.txt"));
                                buffWrite.append("O valor total do pedido foi \n"+"R$ "+String.valueOf(valorTotal));
                                buffWrite.close();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }


                        }









                }
            });
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel finalizar o pedido", "ocorreu um erro", JOptionPane.PLAIN_MESSAGE);
        }

    }
}


