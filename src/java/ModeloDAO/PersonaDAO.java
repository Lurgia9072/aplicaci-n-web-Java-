
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUD;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements CRUD{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p=new Persona();
    
    @Override
    public List listar() {
        ArrayList<Persona>list=new ArrayList<>();
        String sql="SELECT * FROM blaze.orders";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Persona per=new Persona();
                per.setId(rs.getInt("id"));
                per.setCliente(rs.getString("cliente"));
                per.setEstado(rs.getString("estado"));
                per.setfecha(rs.getString("fecha"));
                list.add(per);
            }
        } catch (Exception e) {
            System.out.println("No puedo listar " + e.getLocalizedMessage());
        }finally{
         System.out.println("termina el proceso ");
        }
        return list;
    }

    @Override
    public Persona list(int id) {
        String sql="SELECT * FROM blaze.orders where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setId(rs.getInt("id"));
                p.setCliente(rs.getString("cliente"));
                p.setEstado(rs.getString("estado"));
                p.setfecha(rs.getString("fecha"));
            }
        } catch (Exception e) {
           System.out.println("No puedo listar " + e.getLocalizedMessage());
        }finally{
         System.out.println("termina el proceso ");
        }
        return p;
    }

    @Override
    public boolean add(Persona per) {
       String sql="insert into Orders(cliente, estado, fecha )values('"+per.getCliente()+"','"+per.getEstado()+ "','"+per.getfecha()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Persona per) {
        String sql="update orders set cliente='"+per.getCliente()+"',estado='"+per.getEstado()+ "',fecha='"+per.getfecha()+ "'where id="+per.getId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from orders where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
