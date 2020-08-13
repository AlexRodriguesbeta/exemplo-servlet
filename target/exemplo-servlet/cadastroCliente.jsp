<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="dao.ClienteDao"%>
<%@ page import="model.Cliente"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1">
        <title>Cadastro</title>
    </head>
    <body>
         <%
            Cliente cliente = new Cliente();
            cliente.setNome(request.getParameter("nome")); 
            cliente.setEndereco(request.getParameter("endereco")); 
            cliente.setCpf(request.getParameter("cpf")); 
            cliente.setDataNascimento(request.getParameter("dataNascimento")); 

            try {
                ClienteDao.cadastrar(cliente);
                out.println("Cliente cadastrado com sucesso!"); 
            }catch (SQLException e) {
                out.println("Falha com o banco" + e.getMessage());
            }
    
         %> 

        
         <!--
         <h2> Dados do cliente </h2>
         <p><strong> Nome: </strong> <%=cliente.getNome() %></p>
         <p><strong> Endereço: </strong> <%=cliente.getEndereco() %></p>
         <p><strong> CPF: </strong> <%=cliente.getCpf() %></p>
         <p><strong> Data de nascimento: </strong> <%=cliente.getDataNascimento() %></p>
         -->  

    </body>
</html>