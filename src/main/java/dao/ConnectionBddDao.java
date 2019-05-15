package dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;


public class ConnectionBddDao {

    private String url = "jdbc:hsqldb:hsql://127.0.0.1:9003\",\"SA\",\"";
    Connection connection = null;
    private Logger logger = LogManager.getLogger(ConnectionBddDao.class);


    public void SeConnecter() throws SQLException {
        connection = DriverManager.getConnection(url);
        int countArt = 0;

        PreparedStatement pa = connection.prepareStatement("SELECT  COUNT (*) from BLOG");
        ResultSet rs = pa.executeQuery();
        logger.debug("Requete database" + pa);
        rs.next();
        countArt = rs.getInt(1);
        throw new SQLException();
    }
}
