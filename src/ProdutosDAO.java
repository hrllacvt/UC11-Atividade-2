/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDAO {
    
     private Conexao conexao;
    private Connection conn;
    
    public ProdutosDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
   
    
    public void cadastrarProduto (ProdutosDTO produto){
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES "
                + "(?, ?, ? ) ";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2,produto.getValor());
            stmt.setString(3, produto.getStatus());
            
            stmt.execute();
        }
        
        catch (Exception e){
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }

    }
    
     public void setVendido (ProdutosDTO produto){
            String sql = " UPDATE produtos SET status = 'Vendido' WHERE produtos.id = "
                    +"(?)";
            
            try{
                PreparedStatement stmt = this.conn.prepareStatement(sql);
                stmt.setInt(1,produto.getId());
                
                stmt.execute();
            }
            catch (Exception e){
                System.out.println("Erro ao atualizar status: "+ e.getMessage());
            }
        }
    
    public List<ProdutosDTO> getProdutos(){
        String sql = "SELECT * FROM produtos";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<ProdutosDTO> listaProdutos = new ArrayList<>();
            while(rs.next()){
               ProdutosDTO produtosDTO = new ProdutosDTO();
               
               produtosDTO.setId(rs.getInt("id"));
               produtosDTO.setNome(rs.getString("nome"));
               produtosDTO.setValor(rs.getInt("valor"));
               produtosDTO.setStatus(rs.getString("status"));
               
               listaProdutos.add(produtosDTO);
            }
            return listaProdutos;
        } catch (Exception e){
            return null;
        }
        
       
    }
    
    
    
        
}

