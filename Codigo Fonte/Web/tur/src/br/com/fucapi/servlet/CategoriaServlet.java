package br.com.fucapi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fucapi.jdbc.TurDao;
import br.com.fucapi.tour.Categorias;

@WebServlet("/servletcat")
public class CategoriaServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String varnome = request.getParameter("txtnome");
		String vardesc = request.getParameter("txtdesc");
		
		Categorias addCategoria = new Categorias();
		
		addCategoria.setNome(varnome);
		addCategoria.setDescricao(vardesc);
		
		TurDao dao = new TurDao();
		
		boolean acesso = dao.AdicionarCategoria(addCategoria);
		if (acesso = true){
			out.println("{success:true, error:'error'}");
		}else{
			out.println("{success:false, error:'error'}");
		}
	}
}
