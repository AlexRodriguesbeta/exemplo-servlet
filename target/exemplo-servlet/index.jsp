<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="dao.ClienteDao"%>
<%@ page import="model.Cliente"%>
<%@ page import="util.ConexaoBanco"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="pt-br">
<body>
    
    <%-- <form method="POST" action="cadastroCliente.jsp" name="dados_formulario">
            <h1 style="text-align: center; ">Cadastro de cliente </h1>
            <p> 
                <label for="nome"> Nome: </label> 
                <input type="text" id="nome" name="nome" size="15" maxlenght="15" /> 
            </p> 
            <p> 
                <label for="endereco"> Endereco: </label> 
                <input type="text" id="endereco" name="endereco" size="25" maxlenght="25" /> 
            </p>
            <p> 
                <label for="cpf"> CPF: </label> 
                <input type="text" id="cpf" name="cpf" size="12" maxlenght="12" /> 
            </p> 
            <p> 
                <label for="dataNascimento"> Data de nascimento: </label> 
                <input type="text" id="dataNascimento" name="dataNascimento" size="12" maxlenght="12" /> 
            </p>
            <p>
                <input type="submit" name="btnCadastar" id="btnCadastrar" value="Cadastar" /> 
            </p>
       </form>   --%>
     

       <%
            out.println("Consulta ao banco");

            try {
                ClienteDao dao = new ClienteDao();
                List<Cliente> lstCli = dao.pesquisar();
                out.println("ok");               

                for (Cliente c : lstCli) {
                    out.println("<p>ID: " + c.getIdCliente() + "</p>");
                    out.println("<p>Descrição: " + c.getNome() + "</p>");
                    out.println("<p>Descrição: " + c.getEndereco() + "</p>");
                    out.println("<p>Quantidade: " + c.getCpf() + "</p>");
                    out.println("<p>Valor: " + c.getDataNascimento() + "</p>");
                }

            } catch (SQLException e) {
                out.println("<p>Erro " + e.getMessage() + "</p>");
                
            }          

        %>      
</body>
</html>
