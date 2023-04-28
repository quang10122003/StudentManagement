
package student;
import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Student {

    Connection con = MyConnection.getJDBConnection();
    PreparedStatement ps;

    //lấy hàng tối đa của bảng(auto create id)
    public int getMax() {
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("chọn max(id) trong bảng student");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        }catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id +1;
    }
    // thêm data sinh viên vào table
    public void insert(int id,String hovaten,String ngaysinh,String gioitinh,String gmail,String sdt,String cha,String me,String quequan,String noicutru){
        String sql = "thêm sinh viên ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2, hovaten);
            ps.setString(3, ngaysinh);
            ps.setString(4, gioitinh);
            ps.setString(5,gmail);
            ps.setString(6, sdt);
            ps.setString(7, cha);
            ps.setString(8, me);
            ps.setString(9, quequan);
            ps.setString(10, noicutru);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "sinh viên đc thêm thành công");
            }
        }catch(SQLException ex){
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE,null,ex);
            
        }
        
    }
}
