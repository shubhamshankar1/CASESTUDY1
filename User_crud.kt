import java.sql.DriverManager

data class User_crud(val id:Int,val name:String,val age:Int,val email:String,val phone:Long,val city:String,val state:String,val country:String,val pincode:Int)
fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/demodb"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "shubham")
    println(connection.isValid(0))
    val res=connection.createStatement().executeUpdate("insert into user(id,Name,Age,Email,Phone,City,State,Country,Pincode) VALUES(11,'Billly','47','billy@gmail.com','8907675467','Vize','Ziy','Tft','7656756')")

    if(res>0){
        println("succesfully inserted record into user db")
    }else{
        println("Insert not succesful")
    }
    val update_res=connection.createStatement().executeUpdate("update user set name='Ronnie' where id=8")
    if(update_res>0){
        println("Updated succesfully")
    }else {
        println("Not updated succesful")
    }
    val delete_res=connection.createStatement().executeUpdate("delete from user  where id=10")
        if(delete_res>0){
            println(" Deleted succesfully")
        }else {
            println("Not deleted succesful")
        }

    val query=connection.createStatement()
    val result=query.executeQuery("select * from user")
    val user= mutableListOf<User_crud>()

    while(result.next()){
        val id=result.getInt("id")
        val name=result.getString("Name")
        val age=result.getInt("Age")
        val email=result.getString("Email")
        val phone=result.getLong("Phone")
        val city=result.getString("City")
        val state=result.getString("State")
        val country=result.getString("Country")
        val pincode=result.getInt("Pincode")
        user.add(User_crud(id,name,age,email,phone,city,state,country,pincode))
    }
    println(user)
}
