import java.sql.*;

public class ExecuteQuery02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tecproed","postgres","sansarer67");
        Statement st = con.createStatement();

        //1. Örnek: companies tablosundan en yüksek ikinci number_of_employees değeri olan company ve number_of_employees değerlerini çağırın.

//1. yol offset ve fetch next kullandik
      String sql1=" SELECT company,number_of_employees\n" +
              "FROM companies\n" +
              "ORDER BY number_of_employees DESC\n" +
              "OFFSET 1 ROW\n" +
              "FETCH NEXT 1 ROW ONLY";
     ResultSet resultset1= st.executeQuery(sql1);
     while(resultset1.next()){
         System.out.println(resultset1.getString("company")+"--"+resultset1.getInt("number_of_employees"));


     }
        //2. Yol: Subquery Kullanarak.
        String sql2 = "SELECT company, number_of_employees\n" +
                "FROM companies\n" +
                "WHERE number_of_employees = (SELECT MAX(number_of_employees)\n" +
                "                            FROM companies\n" +
                "                            WHERE number_of_employees < (SELECT MAX(number_of_employees)\n" +
                "                                                         FROM companies));";

        ResultSet resultSet2 =  st.executeQuery(sql2);

        while (resultSet2.next()){

            System.out.println(resultSet2.getString(1)+"--"+resultSet2.getInt(2));

        }

     con.close();
        st.close();
        resultset1.close();
        resultSet2.close();
    }
}
