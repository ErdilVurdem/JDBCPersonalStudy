package manage;

public class QueryManage {

    private String query2="SELECT name FROM u168183796_qaloantec.cron_schedules LIMIT 2";
    private String query3="SELECT remember_token FROM u168183796_qaloantec.admins WHERE email='info@loantechexper.com'";

    private String query04="SELECT charge FROM u168183796_qaloantec.deposits WHERE amount<500 AND trx='4GC9SMZUS69S'";

    private String insertQuery01="INSERT INTO u168183796_qaloantec.admin_password_resets (id,email,token,status) VALUES(?,?,?,?)";

    private String query05="SELECT support_ticket_id FROM u168183796_qaloantec.support_messages WHERE message='1'";

    private String query06="SELECT status FROM u168183796_qaloantec.support_tickets WHERE ticket LIKE '4%'";

    private String query07="SELECT firstname, lastname FROM u168183796_qaloantec.users WHERE country_code!='TR' AND id=11";

    private String deleteQuery01="DELETE FROM u168183796_qaloantec.loans WHERE loan_number=?";

    private String deleteControlQuery01="SELECT * FROM u168183796_qaloantec.loans WHERE loan_number=?";

    private String insertQuery02="INSERT INTO u168183796_qaloantec.device_tokens (id,user_id,is_app,token) VALUES (?,?,?,?)";

    private String query08="SELECT COUNT(*) FROM u168183796_qaloantec.admin_notifications WHERE user_id=1 AND is_read=0";

    private String query09="SELECT COUNT(*)toplam_kullanici FROM u168183796_qaloantec.admin_notifications WHERE user_id=1 AND id>20";

    private String insertQuery03="INSERT INTO u168183796_qaloantec.cron_job_logs (id,cron_job_id,start_at,end_at,duration,error,created_at,updated_at) VALUES (?,?,?,?,?,?,?,?)";

    public String getInsertQuery03() {
        return insertQuery03;
    }

    public String getQuery09() {
        return query09;
    }

    public String getQuery08() {
        return query08;
    }

    public String getInsertQuery02() {
        return insertQuery02;
    }

    public String getDeleteControlQuery01() {
        return deleteControlQuery01;
    }

    public String getDeleteQuery01() {
        return deleteQuery01;
    }

    public String getQuery07() {
        return query07;
    }

    public String getQuery06() {
        return query06;
    }

    public String getQuery05() {
        return query05;
    }

    public String getInsertQuery01() {
        return insertQuery01;
    }

    public String getQuery04() {
        return query04;
    }
    public String getQuery3() {
        return query3;
    }
    public String getQuery2() {
        return query2;
    }
}
