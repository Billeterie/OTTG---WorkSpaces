/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.lal.dao;

import cm.lal.model.User;
import cm.lal.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class UserDao {

    private Connection conn = null;

    public UserDao() {
        conn = DbUtil.getConnection();
    }
//    public static void main(String[] args) throws SQLException {
//        UserDao boo = new UserDao();
//        User u = new User();
//        u.setDateOfBirth(45154384);
//        u.setIduser(Integer.SIZE);
//        u.setFirstname("mola");
//        u.setPassword("mola");
//        boo.addUser(u);
//    }
    public void addUser(User user) throws SQLException {
        PreparedStatement prep = conn.prepareStatement(
                "insert into user values (?,?,?,?,?,?,?)");

        prep.setInt(1, user.getIduser());
        prep.setString(2, user.getFirstname());
        prep.setString(3, user.getMiddlename());
        prep.setString(4, user.getLastname());
        prep.setLong(5, user.getDateOfBirth()); // store dates as long
        prep.setString(6, user.getGender());    // store gender as unit length string
        prep.setString(7, user.getPassword());
        int returnValue = prep.executeUpdate();
        if (returnValue != 0) {
            System.out.println("success with " + returnValue + " rows affected");
        } else {
            System.out.println("success with no return values from SQL");
        }
    }

    public boolean verifyIdentity(String uName, String password) throws SQLException {
        boolean value = false;
//        
//        Statement stat = null;
//        String queryString = "select count (*) from user "
//                + "where firstname=" + uName + " and "
//                + "password=" + password;
//        
//        stat = conn.createStatement();
//        ResultSet res = stat.executeQuery(queryString);
//        
        String query = "select * from user where firstname=? and password=?";
        PreparedStatement prep = conn.prepareStatement(query);
        prep.setString(1, uName);
        prep.setString(2, password);
        ResultSet returnResultSet = prep.executeQuery();
        int i =0;
        while (returnResultSet.next()) {
//            System.out.println("success with " + returnValue + " rows affected"); 
// insert statements return values always. i.e the number of rows affected
            i++;
        } 
        if (i == 1) {
            value = true;
        }
//        else {
//            System.out.println("success with no return values from SQL");
//        }
        return value;
    }
}
