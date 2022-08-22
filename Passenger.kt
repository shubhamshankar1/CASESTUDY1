import java.sql.DriverManager

data class Passenger(val passenger_id:Int,val name:String,val age:Int,val gender:String,val phone:Long)
fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/demodb"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "shubham")
    println(connection.isValid(0))
    val res=connection.createStatement().executeUpdate(" insert into passenger(Passenger_id,Passenger_name,Passenger_age,Gender,Phone) VALUES(6,'John','23','M','9876567543')")

    if(res>0){
        println("succesfully inserted record into user db")
    }else{
        println("Insert not succesful")
    }
    val update_res=connection.createStatement().executeUpdate("update passenger set Passenger_name='Ronnie' where Passenger_id=3")
    if(update_res>0){
        println("Updated succesfully")
    }else {
        println("Not updated succesful")
    }
    val query=connection.createStatement()
    val result=query.executeQuery("select * from passenger")
    val user= mutableListOf<Passenger>()

    while(result.next()){
        val passenger_id=result.getInt("Passenger_id")
        val name=result.getString("Passenger_name")
        val age=result.getInt("Passenger_age")
        val gender=result.getString("Gender")
        val phone=result.getLong("Phone")
        user.add(Passenger(passenger_id,name,age,gender,phone))
    }
    println(user)
}
