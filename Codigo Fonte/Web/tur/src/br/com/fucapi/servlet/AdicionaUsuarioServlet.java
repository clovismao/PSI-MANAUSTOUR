package br.com.fucapi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fucapi.jdbc.TurDao;
import br.com.fucapi.tour.Usuario;


/**
 * Classe destinada a adicionar um novo usuário cadastrado através do formulário de cadastro no
 * banco de dados do sistema.
 * @author JORENILSON
 *
 */
@WebServlet("/servletusuario")
public class AdicionaUsuarioServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		

		
		String varnome =request.getParameter("txtnome");
		String varemail = request.getParameter("txtemail");
		String varusuario = request.getParameter("txtusuario");
		String varsenha = request.getParameter("txtsenha");
	
		
	
		//Criar um novo objeto Usuario
		Usuario addusuario = new Usuario();
		
		
		//Obtem os parâmetros enviado pelo formulário de cadastro
		addusuario.setNome(varnome);
		addusuario.setEmail(varemail);
		addusuario.setUsuario(varusuario);
		addusuario.setSenha(varsenha);	
		
		//Cria um novo objeto TurDao
		TurDao dao = new TurDao();
		
		
		
		//Envia adicionar novo usuário
		boolean acesso = dao.adicionarusuario(addusuario);
		if (acesso = true){
			out.println("{success:true, error:'error'}");
		}else{
			out.println("{success:false, error:'error'}");
		}
	}
}
