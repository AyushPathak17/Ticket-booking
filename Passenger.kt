import java.sql.DriverManager
data class passenger(val Passenger_ID: Int,val Passenger_Name: String,val Passenger_Age:Int,
                      val Gender:String,val Phone:String)

fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/online_ticket_booking"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "MySQL2022")
    println(connection.isValid(0))
//insert query-create
    val res = connection.createStatement().executeUpdate("insert into passengers(Passenger_Name,Passenger_Age,Gender, Phone )values('Amit',25,'M','7667899854')")
    if(res > 0)
    {
        println("record successfully inserted")
    }
    else{
    println("insert not succesfull")
    }
    //update
    val update_res = connection.createStatement().executeUpdate("Update passengers set Passenger_Age=26 where Passenger_ID=2")
    if(update_res > 0)
    {
        println("record successfully inserted")
    }
    else{
        println("insert not succesfull")
    }
    //delete records
    val delete_res=connection.createStatement().executeUpdate("Delete  from passengers where Passenger_ID=6")
    if(delete_res>0)
    {
        println("record succesfully deleted")
    }
    else{
        println("not deleted")
    }



//fetch records from database
    val query = connection.prepareStatement("select* from passengers")
    val result = query.executeQuery()
    val passengers = mutableListOf<passenger>()

    while (result.next())
    {   val Passenger_ID= result.getInt("Passenger_ID")
        val Passenger_Name=result.getString("Passenger_Name")
        val Passenger_Age=result.getInt("Passenger_ID")
        val Gender=result.getString("Gender")
        val Phone=result.getString("Phone")
        passengers.add(passenger(Passenger_ID,Passenger_Name, Passenger_Age, Gender, Phone))
    }
        println(passengers)
}