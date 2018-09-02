



import java.sql.*;


public class AddStudent {

    String uid;
    String name;
    int  id;
    double cgpa;
    int bus_route;
    double depCode;
    int semester;


    public AddStudent( String uid,String name, int id, double cgpa, int bus_route, double depCode, int semester) {
       this.uid = uid;
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
        this.bus_route = bus_route;
        this.depCode = depCode;
        this.semester = semester;





    }


    public void studentConnector()
    {
        try
        {
            String driver="com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            Connection addstu=DriverManager.getConnection("jdbc:mysql://localhost:3306/smartID","root","12345");
            System.out.println("connected");
           PreparedStatement checkin=(PreparedStatement)addstu.prepareStatement("select  max(stuindex) from student");
            ResultSet checkIndex=checkin.executeQuery();
            checkIndex.next();
           int in=checkIndex.getInt(1);
           in++;






            Statement add=addstu.prepareStatement("insert into student values (?,?,?,?,?,?,?,?)");
            ((PreparedStatement) add).setInt(1,in);
            ((PreparedStatement) add).setString(2,uid);
            ((PreparedStatement) add).setString(3,name);
            ((PreparedStatement) add).setInt(4,id);
            ((PreparedStatement) add).setFloat(5, (float) cgpa);
            ((PreparedStatement) add).setInt(6,bus_route);
            ((PreparedStatement) add).setDouble(7,depCode);
            ((PreparedStatement) add).setInt(8,semester);
            int st=((PreparedStatement) add).executeUpdate();


        }catch (Exception ex)
        {

            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String uid= null;
        try {
            Server.runServer();
            uid=GetData.getuid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(uid);
        //AddStudent stu=new AddStudent("furkan alahi",11161212,4.00,1,11,161);
        
        //stu.studentConnector();
    }


}
