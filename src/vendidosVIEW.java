
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author joao
 */
public class vendidosVIEW extends javax.swing.JFrame {

     private void preencherTabel()
                {
                    
                    ProdutosDAO produtosDAO = new ProdutosDAO();
                    //Pegar os dados dos funcionarios da lista e colocar dentro da tabela
                    List<ProdutosDTO> listaVendidos = produtosDAO.listarProdutosVendidos();
                    
                    //Criar uma variavel do tipo DefaultTableModel, pois é com esse tipo que conseguimos inserir dinamicamente linhas dentro da JTable        
                    DefaultTableModel tabelaVendidos = (DefaultTableModel) tblVendidos.getModel();
                    //permite clicar nas colunas para ordenar por ordem crescente ou decrescente
//                   
                    //Limpar a tabela para preencher com os novos dados
                    tabelaVendidos.setNumRows(0);
                            
                     tblVendidos.setRowSorter(new TableRowSorter(tabelaVendidos));
                    //Percorrer o listaFunc inserir na tabelaFuncionarios
                    
                    for (ProdutosDTO p : listaVendidos) { //em cada volta do laço for, o mesmo adiciona uma dado(funcionario) dentro da variavel f
                        Object[] obj = new Object[] { 
                            p.getId(),                           //id
                            p.getNome(),                     //nomefuncionario
                            p.getValor(),   //Empresa
                            p.getStatus()                  //Data de Admissão
                                       
                        };
                        //colocar os dados da variavel obj dentro da tabela
                        tabelaVendidos.addRow(obj);
                        
                    }    
                 }
    public vendidosVIEW() {
        initComponents();
        preencherTabel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendidos = new javax.swing.JTable();
        btnRecarregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblVendidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Valor", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblVendidos);

        btnRecarregar.setText("Recarregar");
        btnRecarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecarregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRecarregar)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnRecarregar)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecarregarActionPerformed
        preencherTabel();
    }//GEN-LAST:event_btnRecarregarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vendidosVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vendidosVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vendidosVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vendidosVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vendidosVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRecarregar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVendidos;
    // End of variables declaration//GEN-END:variables
}
