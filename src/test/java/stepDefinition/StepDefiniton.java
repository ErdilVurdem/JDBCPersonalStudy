package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.sl.In;
import manage.QueryManage;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.JDBCReusableMethods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class StepDefiniton {

    ResultSet resultSet;
    String query;
    String controlQuery;
    PreparedStatement preparedStatement;
    int rowCount;

    QueryManage queryManage=new QueryManage();

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {
        JDBCReusableMethods.getConnection();
    }
    @Given("Query02 hazirlanir ve execute edilir.")
    public void query02_hazirlanir_ve_execute_edilir() throws SQLException {
        query=queryManage.getQuery2();
        resultSet=JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet02 sonuclari islenir.")
    public void result_set02_sonuclari_islenir() throws SQLException {

        List<String> expectedNames=new ArrayList<>();
        expectedNames.add("5 Minutes");
        expectedNames.add("10 Minutes");

        List<String> actualNames=new ArrayList<>();
        while (resultSet.next()){
            String names=resultSet.getString("name");
            actualNames.add(names);
        }

        for (int i = 0; i <actualNames.size() ; i++) {
            Assert.assertEquals(expectedNames.get(i),actualNames.get(i));
            System.out.println(i+". index dogrulandi");
        }

    }
    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {
        JDBCReusableMethods.closeConnection();
    }

    @Given("Query01 hazirlanir ve execute edilir.")
    public void query01_hazirlanir_ve_execute_edilir() throws SQLException {
        query="SELECT user_id FROM u168183796_qaloantec.deposits WHERE amount BETWEEN 100 AND 500";
        resultSet=JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet01 sonuclari islenir.")
    public void result_set01_sonuclari_islenir() throws SQLException {
        resultSet.next();
        int actualResult=resultSet.getInt("user_id");
        int expectedResult=1;

        Assert.assertEquals(expectedResult,actualResult);

    }
    //Database içindeki "admins" tablosunda "email=info@loantechexper.com" olan datanın "remember_token" bilgisini doğrulayınız
    @Given("Query03 hazirlanir ve execute edilir.")
    public void query03_hazirlanir_ve_execute_edilir() throws SQLException {
        query=queryManage.getQuery3();
        resultSet=JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet03 sonuclari islenir.")
    public void result_set03_sonuclari_islenir() throws SQLException {
        resultSet.next();
        String actualResult=resultSet.getString("remember_token");
        String expectedResult="1xUgfVUD1Ggx5CVz7mxLvcye8RXRbeFqSktSIkhya321TqDkLOsqhys4pnJv";

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Given("Query04 hazirlanir ve execute edilir.")
    public void query04_hazirlanir_ve_execute_edilir() throws SQLException {
        query=queryManage.getQuery04();
        resultSet=JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet04 sonuclari islenir.")
    public void result_set04_sonuclari_islenir() throws SQLException {
        resultSet.next();
        int actualResult=resultSet.getInt("charge");
        String expectedResult=ConfigReader.getProperty("query04Charge");

        assertEquals(Integer.parseInt(expectedResult),actualResult);
    }

    @Given("InsertQuery01 hazirlanir ve execute edilir.")
    public void ınsert_query01_hazirlanir_ve_execute_edilir() throws SQLException {
        query=queryManage.getInsertQuery01();
        preparedStatement=JDBCReusableMethods.getConnection().prepareStatement(query);

        preparedStatement.setInt(1,88999);
        preparedStatement.setString(2,"mehmet1245@mehmet.com");
        preparedStatement.setString(3,"f65445");
        preparedStatement.setInt(4,7);

        rowCount=preparedStatement.executeUpdate();
    }
    @Given("InsertQuery01 sonuclari dogrulanir")
    public void ınsert_query01_sonuclari_dogrulanir() {
        assertEquals(1,rowCount);
    }

    @Given("Query05 hazirlanir ve execute edilir.")
    public void query05_hazirlanir_ve_execute_edilir() throws SQLException {
        query=queryManage.getQuery05();
        resultSet=JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet05 sonuclari islenir.")
    public void result_set05_sonuclari_islenir() throws SQLException {
        resultSet.next();
        int expectedResult=13;
        int actualResult=resultSet.getInt("support_ticket_id");

        assertEquals(expectedResult,actualResult);
    }

    @Given("Query06 hazirlanir ve execute edilir.")
    public void query06_hazirlanir_ve_execute_edilir() throws SQLException {
        query=queryManage.getQuery06();
        resultSet=JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet06 sonuclari islenir.")
    public void result_set06_sonuclari_islenir() throws SQLException {
        List<String> expectedList=new ArrayList<>();
        expectedList.add("3");
        expectedList.add("1");
        expectedList.add("0");

        List<String> actualList=new ArrayList<>();
        while (!resultSet.isLast()){
            resultSet.next();
            actualList.add(resultSet.getString("status"));
         }
        int number=0;
        for (int i = 0; i < actualList.size() ; i++) {
            for (int j = 0; j <expectedList.size() ; j++) {
                if (actualList.get(i).equals(expectedList.get(j))){
                    number++;
                }
            }
        }
        assertEquals(62,number);
    }

    @Given("Query07 hazirlanir ve execute edilir.")
    public void query07_hazirlanir_ve_execute_edilir() throws SQLException {
         query=queryManage.getQuery07();
         resultSet=JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet07 sonuclari islenir.")
    public void result_set07_sonuclari_islenir() throws SQLException {
        resultSet.next();
        String expectedFirstName=ConfigReader.getProperty("q7firstName");
        String expectedLastName=ConfigReader.getProperty("q7lastName");

        String actualFirstName=resultSet.getString("firstname");
        String actualLastName=resultSet.getString("lastname");

        assertEquals(expectedFirstName,actualFirstName);
        assertEquals(expectedLastName,actualLastName);

    }
    @Given("DeleteQuery01 hazirlanir ve execute edilir.")
    public void delete_query01_hazirlanir_ve_execute_edilir() throws SQLException {
        query=queryManage.getDeleteQuery01();
        preparedStatement=JDBCReusableMethods.getConnection().prepareStatement(query);
        String silinecekLoanNumber=ConfigReader.getProperty("dQuery01loanNumber");

        preparedStatement.setString(1,silinecekLoanNumber);
        rowCount=preparedStatement.executeUpdate();

        System.out.println(rowCount);
        assertEquals(1,rowCount);

        controlQuery=queryManage.getDeleteControlQuery01();
        preparedStatement=JDBCReusableMethods.getConnection().prepareStatement(controlQuery);
        preparedStatement.setString(1,silinecekLoanNumber);
        resultSet=preparedStatement.executeQuery();

        assertFalse(resultSet.next());


    }
    @Given("DeleteQuery01 silindigi dogrulanir.")
    public void delete_query01_silindigi_dogrulanir() throws SQLException {
        // yukarıdaki adımda bu adımı yaptık
    }

    @Given("InsertQuery02 hazirlanir ve execute edilir.")
    public void ınsert_query02_hazirlanir_ve_execute_edilir() throws SQLException {
        query=queryManage.getInsertQuery02();
        preparedStatement=JDBCReusableMethods.getConnection().prepareStatement(query);

        preparedStatement.setString(1,ConfigReader.getProperty("insertQ02ID"));
        preparedStatement.setString(2,ConfigReader.getProperty("insertQ02UserID"));
        preparedStatement.setString(3,ConfigReader.getProperty("insertQ02IsApp"));
        preparedStatement.setString(4,ConfigReader.getProperty("insertQ02Token"));

        rowCount=preparedStatement.executeUpdate();
    }
    @Given("InsertQuery02 sonuclari dogrulanir")
    public void ınsert_query02_sonuclari_dogrulanir() {
        assertEquals(1,rowCount);
    }

    @Given("Query08 hazirlanir ve execute edilir.")
    public void query08_hazirlanir_ve_execute_edilir() throws SQLException {
      query=queryManage.getQuery08();
      resultSet=JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet08 sonuclari islenir.")
    public void result_set08_sonuclari_islenir() throws SQLException {
        resultSet.next();
        int actualResult=resultSet.getInt("COUNT(*)");
        assertEquals(2,actualResult);
    }

    @Given("Query09 hazirlanir ve execute edilir.")
    public void query09_hazirlanir_ve_execute_edilir() throws SQLException {
        query=queryManage.getQuery09();
        resultSet=JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet09 sonuclari islenir.")
    public void result_set09_sonuclari_islenir() throws SQLException {
        resultSet.next();
        int actualResult=resultSet.getInt("toplam_kullanici");
        assertEquals(6,actualResult);
    }
    @Given("InsertQuery03 hazirlanir ve execute edilir.")
    public void ınsert_query03_hazirlanir_ve_execute_edilir() throws SQLException {
        Date date=new Date();

        query=queryManage.getInsertQuery03();
        preparedStatement=JDBCReusableMethods.getConnection().prepareStatement(query);

        preparedStatement.setString(1,ConfigReader.getProperty("insertQ03ID"));
        preparedStatement.setString(2,ConfigReader.getProperty("insertQ03cronjobID"));
        preparedStatement.setTimestamp(3,new java.sql.Timestamp(date.getTime()));
        preparedStatement.setTimestamp(4,new Timestamp(121,2,5,12,15,10,0));
        preparedStatement.setString(5,ConfigReader.getProperty("insertQ03duration"));
        preparedStatement.setString(6,ConfigReader.getProperty("insertQ03error"));
        preparedStatement.setTimestamp(7,new Timestamp(118,9,3,27,18,10,0));
        preparedStatement.setTimestamp(8,new Timestamp(120,10,13,1,15,20,0));

        rowCount=preparedStatement.executeUpdate();
    }
    @Given("InsertQuery03 sonuclari dogrulanir")
    public void ınsert_query03_sonuclari_dogrulanir() {
        assertEquals(1,rowCount);
    }

}
