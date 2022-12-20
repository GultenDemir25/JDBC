import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. adim: Drivera kaydol
        Class.forName("org.postgresql.Driver");

        //2. adim:database'e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tecproed", "postgres", "sansarer67");

        //3. adim:Statement olustur
        Statement st = con.createStatement();

        //4. adim:Query calistir

        /*
        execute metodu DDL(create,drop,alter table) ve DQL(select) icin kullanilabilir
        1)Eger  execute metodu DDL icin kullanilirsa 'false' return eder.
        2)Eger  execute metodu DQL icin kullanilirsa ResultSet alindiginda 'true' aksi halde 'false' verir
         */
        //1. Ornek:/1.Örnek: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.
        boolean sql1 = st.execute("CREATE TABLE workers(worker_id VARCHAR(20),worker_name VARCHAR(20),worker_salary INT)");
        System.out.println(sql1);  // False return eder cunku data cagirmiyoruz


        //2.Ornek: table'a worker_address sutunu ekleyerek alter yapin
        String sql2 = "ALTER TABLE workers  ADD worker_address VARCHAR(80)";
        boolean sql2b= st.execute(sql2);
        System.out.println(sql2b);

         // 3. soru : workers table'ini siliniz

        String sql3 = "drop table workers";
        boolean sql3b=st.execute(sql3);
        System.out.println(sql3b);
        //5. adim:Baglanti ve statement'i kapat.
         con.close();
         st.close();

    }
}
