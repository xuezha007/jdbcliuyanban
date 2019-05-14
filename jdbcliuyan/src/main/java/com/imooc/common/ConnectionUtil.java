package com.imooc.common;

import java.sql.*;

/**
数据库操作公共类
 */

public final  class  ConnectionUtil {
    private static  String url = "jdbc:mysql://localhost:3306/message_board";
    private static String user ="root";
    private static String password ="mysql";
    private ConnectionUtil(){};
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到所要驱动");
            e.printStackTrace();

        } finally {
        }

    }
//    获得数据库连接
public static Connection getConnection(){
    try {
        return DriverManager.getConnection(url,user,password);
    } catch (SQLException e) {
//        创建数据库失败
        e.printStackTrace();
    }
    return null;
}

public static  void release(ResultSet rs, Statement stmt,Connection conn)
{
    try {
        if (rs!=null)
        {
            rs.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (stmt!=null)
            {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn!=null)
                {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

}
