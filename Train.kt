import java.sql.DriverManager

data class Train(val train_id:Int,val train_name:String,val source:String,val destination:String,val start:String,val arrival:String)
fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/demodb"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "shubham")
    println(connection.isValid(0))
    val res=connection.createStatement().executeUpdate("insert into train(Train_id,Train_no,Train_name,Source,Destination,Start_Date_Time,Arrival_time) VALUES(5,'23474','CF Express','CHENNAI','BANGALORE','01_04_2021 9:00AM','02_04_2021 12:00PM')")

    if(res>0){
        println("succesfully inserted record into user db")
    }else{
        println("Insert not succesful")
    }
    val update_res=connection.createStatement().executeUpdate("update train set Source='Mumbai' where Train_id=2")
    if(update_res>0){
        println("Updated succesfully")
    }else {
        println("Not updated succesful")
    }
    val query=connection.createStatement()
    val result=query.executeQuery("select * from train")
    val user= mutableListOf<Train>()

    while(result.next()){
        val train_id=result.getInt("Train_id")
        val train_name=result.getString("Train_name")
        val source=result.getString("Source")
        val destination=result.getString("Destination")
        val start=result.getString("Start_Date_Time")
        val arrival=result.getString("Arrival_time")
        user.add(Train(train_id,train_name,source,destination,start,arrival))
    }
    println(user)
}
