import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "şifreniz");
                Statement st = con.createStatement();

        /*
            PreparedStatement interface, birden cok kez calistirilabilen onceden derlenmis bir SQL kodunu temsil eder.
            Parametrelendirilmis(Parameterised) SQL query(sorgu)'leri ile calisir. Bir sorguyu 0 veya daha fazla parametre ile kullanabiliriz

        */

                //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.

                //1.Adım : PreparedStatement query'sini olusturalım
                String sql1 = "update companies set number_of_employees = ? where company= ? ";

                //2.Adım : PreparedStatement objesini olusturalım
                PreparedStatement pst1=con.prepareStatement(sql1);


                //3.Adım : set int(),setString .. methdlarini kullanarak soru isaretlerinin yerine deger girelim
                pst1.setInt(1,9999);
                pst1.setString(2,"IBM");

                //



            }
        }


