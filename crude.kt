import java.sql.DriverManager
data class user(val id:Int, val name: String, val age:Int,val email: String,val phone: String, val city: String,
val state: String, val country: String, val pincode: String)

fun main(args: Array<String>) {
    val jdbcUrl= "jdbc:mysql://localhost:3306/jotax"
    val connection =DriverManager.getConnection(jdbcUrl,"root","MySQL2022")
    println(connection.isValid(0))
//insert query
    val res=connection.createStatement().executeUpdate("insert into users(name,age,email,phone,city,state,country,pincode)values('Amit', 25,'amitsrr@gmail.com','7685574688','Delhi','Delhi','India','100021')")

            if (res>0) {
                println("insert successfull")
            }
        else {
                println("Not Succesfull")
            }
    //update records
    val update_res =connection.createStatement().executeUpdate("update users set name='Tejas' where id=1 ")
    if(update_res>0)
    {
        println("record succesfully updated")
    }
    else {
        println("insert not update")
    }



//fetch records from database
    val query = connection.prepareStatement("select* from users")
    val result =query.executeQuery()
    val users = mutableListOf<user>()

    while (result.next()){
        val id= result.getInt("id")
        val name=result.getString("name")
        val age=result.getInt("age")
        val email=result.getString("email")
        val phone=result.getString("phone")
        val city=result.getString("city")
        val state=result.getString("state")
        val country=result.getString("country")
        val pincode=result.getString("pincode")
        users.add(user(id, name,age,email,phone,city,state,country,pincode))


    }
    println(users)
}