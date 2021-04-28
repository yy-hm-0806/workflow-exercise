package base;

import java.sql.*;
public class Chaxun {
    final static String driver = "com.mysql.jdbc.Driver";
    //这里我的数据库是cxxt
    final static String url = "jdbc:mysql://127.0.0.1:3306/ruangong";
    final static String user = "root";
    final static String password = "123456";

    public static void main(String[] args) {
       queryDb();
    }

    public static void queryDb() {
        Connection con;
        try {
            //注册JDBC驱动程 序
            Class.forName(driver);
            //建立连接
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }

            Statement stmt = con.createStatement();
//            String sql = "INSERT INTO tab1 (title,author,submission_date) VALUES ('li','xiao','2020-07028')";
            String sql = "select title,author,submission_date from tab1";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");

                System.out.println("title : " + title);
                System.out.println("author : " + author);
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}


