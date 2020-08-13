package exibir;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import model.Cliente;
import dao.ClienteDao;



public class ExibirCliente extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        /*
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter saida = resp.getWriter(); 

        saida.println("<html>");
        saida.println("<bodu>");
        saida.println("<p>Teste de Servlet</p>");
        saida.println("</body>");
        saida.println("</html>");

        saida.flush();
        saida.close();
        */ 

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter saida = resp.getWriter();

        String reqId = req.getParameter("id");

        ClienteDao dao = new ClienteDao();
        Gson gson = new Gson();

        try {
            if (reqId != null) {
                int id = Integer.parseInt(reqId);
                Cliente cli = dao.pesquisarPorId(id);
                saida.println(gson.toJson(cli));
            }
            else {
                List<Cliente> clie = dao.pesquisar();
                saida.println(gson.toJson(clie));
            }
        }
        catch (SQLException | NumberFormatException e) {
            saida.println("Erro: " + e.getMessage());
        }
        finally {
            saida.flush();
            saida.close();
        }

    }
    
}