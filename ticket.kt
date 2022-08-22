import java.sql.DriverManager
data class tickets(val id:Int,val Ticket_Number:Int,val Passenger_ID:Int,val Train_Id: Int, val Ticket_price:Int)

fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/online_ticket_booking"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "MySQL2022")
    println(connection.isValid(0))
    //insert query-create
    val res = connection.createStatement().executeUpdate("insert into ticket(Ticket_Number,Passenger_ID,Train_Id,Ticket_price )values(45458,2,1002,2700)")
    if(res > 0)
    {
        println("record successfully inserted")
    }
    else {
        println("insert not succesfull")

    }
//fetch records from database
        val query = connection.prepareStatement("select* from ticket")
        val result = query.executeQuery()
        val ticket = mutableListOf<tickets>()

        while (result.next()) {
            val id = result.getInt("id")
            val Ticket_Number = result.getInt("Ticket_Number")
            val Passenger_ID = result.getInt("Passenger_ID")
            val Train_Id = result.getInt("Train_Id")
            val Ticket_price = result.getInt("Ticket_price")

            ticket.add(tickets(id, Ticket_Number, Passenger_ID, Train_Id, Ticket_price))
        }
        println(ticket)
    }