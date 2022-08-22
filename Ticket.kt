import java.sql.DriverManager

data class Ticket(val id:Int,val ticket_no:Int,val passenger_id:Int,val train_id:Int,val ticket_price:Int)
fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/demodb"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "shubham")
    println(connection.isValid(0))
    val res=connection.createStatement().executeUpdate( "insert into ticket(id,Ticket_no,Passenger_id,Train_id,Ticket_price) VALUES(007,'54675',2,2,'1400')");
    if(res>0){
        println("succesfully inserted record into user db")
    }else{
        println("Insert not succesful")
    }
    val update_res=connection.createStatement().executeUpdate("update ticket set Ticket_price='1600' where id=2")
    if(update_res>0){
        println("Updated succesfully")
    }else {
        println("Not updated succesful")
    }
    val delete_res=connection.createStatement().executeUpdate("delete from ticket  where id=5")
    if(delete_res>0){
        println(" Deleted succesfully")
    }else {
        println("Not deleted succesful")
    }
    val query=connection.createStatement()
    val result=query.executeQuery("select * from ticket")
    val user= mutableListOf<Ticket>()

    while(result.next()){
        val id=result.getInt("id")
        val ticket_no=result.getInt("Ticket_no")
        val passenger_id=result.getInt("Passenger_id")
        val train_id=result.getInt("Train_id")
        val ticket_price=result.getInt("Ticket_price")
        user.add(Ticket(id,ticket_no,passenger_id,train_id,ticket_price))
    }
    println(user)
}

