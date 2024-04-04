Feature: Query execute

  @query01
  Scenario: Database içindeki "deposits" toblosunda "amount" değeri
  100$ ile 500$ arasında olan user_id’leri doğrulayınız.

    * Database baglantisi kurulur.
    * Query01 hazirlanir ve execute edilir.
    * ResultSet01 sonuclari islenir.
    * Database baglantisi kapatilir.

  @query02
  Scenario: Database içindeki "cron_schedules" tablosunda ilk 2 kaydın
            "name" bilgisini (5 Minutes, 10 Minutes) doğrulayınız.

    * Database baglantisi kurulur.
    * Query02 hazirlanir ve execute edilir.
    * ResultSet02 sonuclari islenir.
    * Database baglantisi kapatilir.

  @query03
  Scenario: Database içindeki "admins" tablosunda "email=info@loantechexper.com" olan datanın "remember_token" bilgisini doğrulayınız
    * Database baglantisi kurulur.
    * Query03 hazirlanir ve execute edilir.
    * ResultSet03 sonuclari islenir.
    * Database baglantisi kapatilir.

  @query04
  Scenario: Database içindeki "cron_schedules" tablosunda ilk 2 kaydın "name" bilgisini doğrulayınız
    * Database baglantisi kurulur.
    * Query04 hazirlanir ve execute edilir.
    * ResultSet04 sonuclari islenir.
    * Database baglantisi kapatilir.

  @insertQuery01
  Scenario: Database içindeki "admin_password_resets" tablosuna aynı anda birden fazla veriyi ekleyiniz.
    * Database baglantisi kurulur.
    * InsertQuery01 hazirlanir ve execute edilir.
    * InsertQuery01 sonuclari dogrulanir
    * Database baglantisi kapatilir.

    @query05
    Scenario: Database içindeki "Support_messages" tablosunda "message" bilgisi "?" olan datanın "support_ticket_id" sini doğrulayınız.
    * Database baglantisi kurulur.
    * Query05 hazirlanir ve execute edilir.
    * ResultSet05 sonuclari islenir.
    * Database baglantisi kapatilir.

    @query06
    Scenario: Database içindeki "support_tickets" tablosunda "ticket" değeri 4 ile başlayan dataların "status" bilgisini doğrulayınız.
      * Database baglantisi kurulur.
      * Query06 hazirlanir ve execute edilir.
      * ResultSet06 sonuclari islenir.
      * Database baglantisi kapatilir.

    @query07
    Scenario: Database üzerinde "Users" tablosunda "country_code=TR" olmayan ve "id=11" olan datanın "firstname" ve "lastname" bilgilerini doğrulayınız.
      * Database baglantisi kurulur.
      * Query07 hazirlanir ve execute edilir.
      * ResultSet07 sonuclari islenir.
      * Database baglantisi kapatilir.

    @deleteQuery01
    Scenario: Database üzerinden "loans" tablosunda "loan_number" girerek istenen datayı siliniz ve silindiğini doğrulayınız.
      * Database baglantisi kurulur.
      * DeleteQuery01 hazirlanir ve execute edilir.
      * DeleteQuery01 silindigi dogrulanir.
      * Database baglantisi kapatilir.

    @insertQuery02
    Scenario: Database üzerinde "divice_tokens" tablosuna istenen veriyi tek sorguda ekleyiniz.
      * Database baglantisi kurulur.
      * InsertQuery02 hazirlanir ve execute edilir.
      * InsertQuery02 sonuclari dogrulanir
      * Database baglantisi kapatilir.

    @query08
    Scenario: Database üzerinde "admin_notifications" tablosunda "user id= 1" ve "is_read=0"olan kullanıcı sayılarının adedini doğrulayınız.
      * Database baglantisi kurulur.
      * Query08 hazirlanir ve execute edilir.
      * ResultSet08 sonuclari islenir.
      * Database baglantisi kapatilir.

    @query09
    Scenario: Database üzerinde "admin_notifications" tablosunda "user id =2 " olan kullanıcıların "id numarası 20 den büyük olanları" doğrulayınız.
      * Database baglantisi kurulur.
      * Query09 hazirlanir ve execute edilir.
      * ResultSet09 sonuclari islenir.
      * Database baglantisi kapatilir.

    @insertQuery03
    Scenario: Database üzerinde "cron_job_logs" tablosuna veri girişi yapıp tabloya eklendiğini doğrulayınız.
      * Database baglantisi kurulur.
      * InsertQuery03 hazirlanir ve execute edilir.
      * InsertQuery03 sonuclari dogrulanir
      * Database baglantisi kapatilir.

  @query10
  Scenario: Database üzerinde "admin_notifications" tablosunda "user id =2 " olan kullanıcıların "id numarası 20 den büyük olanları" doğrulayınız.
    * Database baglantisi kurulur.
    * Query10 hazirlanir ve execute edilir.
    * ResultSet10 sonuclari islenir.
    * Database baglantisi kapatilir.









