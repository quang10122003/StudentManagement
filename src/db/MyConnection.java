
package db;
import com.mysql.cj.xdevapi.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import student.Student;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import student.Account;
// kết nối mysql 
public class MyConnection {
    public  Connection getJDBConnection(){
       String url = "jdbc:mysql://localhost:3306/student_management";
       String user ="root";
       String password ="quangcuon2k3";
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           return DriverManager.getConnection(url, user, password);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return null;
   }    
   // tham chiếu accunt đến bảng admin trên database 
    public boolean login(String username ,String password){
        Connection conn = getJDBConnection();
        String sql ="SELECT * FROM admin WHERE username = ? and password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    // đăng ký  
    public void register(Account account){
        Connection conn = getJDBConnection();
        String sql = "INSERT INTO admin (username, password) VALUES(?,?)";
        try {
            PreparedStatement ps =  conn.prepareStatement(sql);
            ps.setString(1,account.getUsername());
            ps.setString(2,account.getPassword());
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean loginSv(String username ,String password){
        Connection conn = getJDBConnection();
        String sql ="SELECT * FROM tksv WHERE username = ? and id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
