package database;

import javax.security.auth.login.Configuration;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;

public class SQLServerDatabaseConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        HashMap<String, String> columnType = new HashMap<String, String>();
        columnType.put("-7", "BIT");
        columnType.put("-6", "TINYINT");
        columnType.put("-5", "BIGINT");
        columnType.put("-4", "LONGVARBINARY");
        columnType.put("-3", "VARBINARY");
        columnType.put("-1", "LONGVARCHAR");
        columnType.put("0", "NULL");
        columnType.put("1", "CHAR");
        columnType.put("2", "NUMERIC");
        columnType.put("3", "DECIMAL");
        columnType.put("4", "INTEGER");
        columnType.put("5", "SMALLINT");
        columnType.put("6", "FLOAT");
        columnType.put("7", "REAL");
        columnType.put("8", "DOUBLE");
        columnType.put("12", "VARCHAR");
        columnType.put("91", "DATE");
        columnType.put("92", "TIME");
        columnType.put("93", "TIMESTAMP");
        columnType.put("1111", "OTHER");
        String connectionUrl = "jdbc:sqlserver://172.16.159.172:1433;" +
                "databaseName=DB_ECS;user=Price@D1G!User;password=BH@r!r@XM1396";

        // Declare the JDBC objects.
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(connectionUrl);
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ali.rahmani\\IdeaProjects\\initialSync\\src\\main\\resources\\SQL.txt"));
        while (true) {
            String SQL = reader.readLine();
            if (SQL == null) break;
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            ResultSetMetaData metaData = rs.getMetaData();
            String tableName = metaData.getTableName(1);
            System.out.println(SQL);
            System.out.println("===================================");
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i < columnCount; i++) {
                String index = String.valueOf(metaData.getColumnType(i));
                System.out.println(metaData.getColumnLabel(i) + " " + columnType.get(index) + ",");
            }
            System.out.println("------------------------------------");
        }


    }

}
