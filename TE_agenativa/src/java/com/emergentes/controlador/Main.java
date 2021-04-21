package com.emergentes.controlador;

import com.emergentes.modelo.Contacto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bd_agenda";
        String usuario = "root";
        String password = "";
        
        Connection conn = null;
        String sql = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Contacto> lista = new ArrayList<Contacto>();
         
        
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            sql = "select * from contactos";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Contacto c = new Contacto();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setCorreo(rs.getString("correo"));
                c.setTelefono(rs.getString("telefono"));
                c.toString();
                lista.add(c);
            }
            
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ClassNotFoundException e){
            System.out.println("Error en driver" + e.getMessage());
        } catch (SQLException e){
            System.out.println("Error al conectar" + e.getMessage());
        }
    }


}
