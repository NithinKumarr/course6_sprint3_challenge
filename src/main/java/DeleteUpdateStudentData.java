import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DeleteUpdateStudentData {
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/School","root","Bunny@123");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public void deleteStudentData(int RollNo) {
        try {
            getConnection();
            String sql = "delete from Student where RollNo=?";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, RollNo);
            statement.executeUpdate();
            System.out.println("Record Deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateStudentData(String name) {
        try {
            getConnection();
            String sql = "update Student set name=? where TotalMarks=678 and RollNo=15";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println("Record updated");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        DeleteUpdateStudentData SalesDataDemo = new DeleteUpdateStudentData();
        SalesDataDemo.deleteStudentData(14);
        SalesDataDemo.updateStudentData("Jim");
    }
}
