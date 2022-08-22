import java.sql.DriverManager
data class Trains(val Train_Id: Int,val Train_No: Int,val Train_Name:String,
                  val Source:String,val Destination:String,
                  val Start_Date_Time:String,val Arrival_Time:String)

fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/online_ticket_booking"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "MySQL2022")
    println(connection.isValid(0))


//fetch records from database
    val query = connection.prepareStatement("select* from train")
    val result = query.executeQuery()
    val train = mutableListOf<Trains>()
//insert query-create
    val res = connection.createStatement().executeUpdate("insert into train(Train_No,Train_Name,Source,Destination,Start_Date_Time,Arrival_Time )values(33254,'Alleppy Express','Dhanbad','Alleppy','16-08-2022 15:30','19-08-2022 11:15')")
    if(res > 0)
    {
        println("record successfully inserted")
    }
    else {
        println("insert not succesfull")
    }
    while (result.next())
    {   val Train_Id= result.getInt("Train_Id")
        val Train_No=result.getInt("Train_No")
        val Train_Name=result.getString("Train_Name")
        val Source=result.getString("Source")
        val Destination=result.getString("Destination")
        val Start_Date_Time=result.getString("Start_Date_Time")
        val Arrival_Time=result.getString("Arrival_Time")
        train.add(Trains(Train_Id, Train_No, Train_Name, Source, Destination, Start_Date_Time, Arrival_Time))
    }
    println(train)
}