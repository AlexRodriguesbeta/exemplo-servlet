package util;

import java.sql.Connection;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.SQLException;

public class ConexaoBanco {

    private static final String HOST = "localhost";
    private static final String BANCO = "dbteste2";
    private static final String USUARIO = "alex";
    private static final String SENHA = "1234";

    public static Connection getConexao() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName(HOST);
        ds.setDatabaseName(BANCO);
        ds.setUser(USUARIO);
        ds.setPassword(SENHA);
        
        ds.setServerTimezone("UTC");
        ds.setConnectTimeout(2000);

        return ds.getConnection();
    }

}