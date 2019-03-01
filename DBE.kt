

import java.sql.*

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
*/
object DBE {

    private var DEFAULT_DRIVER_CLASS = "com.mysql.jdbc.Driver"
    private var hostname = "localhost"
    private var dbName = "gamebook"
    private var port = 3306
    private val DEFAULT_URL = "jdbc:mysql://$hostname:$port/$dbName"
    private const val DEFAULT_USERNAME = "willep"
    private const  val DEFAULT_PASSWORD = "mypass"

    @JvmStatic
    fun main(args: Array<String>) {
        var connection: Connection? = null

        try {
            Class.forName(DEFAULT_DRIVER_CLASS)
            connection = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD)

            // SQL queries goes here
            var ps: PreparedStatement? = null
            var rs: ResultSet? = null
            ps = connection!!.prepareStatement("SELECT * FROM `story`")
            rs = ps!!.executeQuery()

            while (rs!!.next()) {
                val id = rs.getString("id")
                val text = rs.getString("text")
                println("$id , $text")
            }

        } catch (e: SQLException) {
            System.err.println(e.message)
        } catch (e: Exception) {
            System.err.println(e)
        }

    }
}
