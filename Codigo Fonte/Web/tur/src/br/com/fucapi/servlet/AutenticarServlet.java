package br.com.fucapi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fucapi.jdbc.Conexao;

/**
 * Classe destinada a processar a autenticação do usuário.
 * 
 * @author JORENILSON
 *
 */
@WebServlet("/autenticar")
public class AutenticarServlet extends HttpServlet {
	Connection conexao = new Conexao().getConnection();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int contador=0;
		
		
		String varusuario = request.getParameter("txtusuario");
		String varsenha = request.getParameter("txtsenha");
		
		try {
			PreparedStatement stmt = conexao
					.prepareStatement("select * from tbcadusuarios where usuario = ? AND senha = ?");
			stmt.setString(1, varusuario);
			stmt.setString(2, varsenha);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				contador++;
			}
			rs.close();
			stmt.close();
			
			if (contador>=1){
				//Redireciona para a página principal do Sistema.jsp
				response.sendRedirect("site.jsp");	
			}else{
				out.println("Acesso negado! Verifique seu usuário e senha de acesso e tente novamente");
			}
			
			
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
