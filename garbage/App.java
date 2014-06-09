import java.lang.Exception;
import java.lang.Process;
import java.lang.ProcessBuilder;
import java.lang.Runtime;
// на данный момент точно рабочий  только jsch-0.1.51.jar
import com.jcraft.jsch.*;


// Робит
public class App {
    public static void main ( String[] args) throws Exception {

        String command = args[0] + " " +  args[1];

        Process p = Runtime.getRuntime().exec(command);

        JSch jsch=new JSch();
    }
}



