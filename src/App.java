import java.lang.Exception;
import java.lang.Process;
import java.lang.ProcessBuilder;
import java.lang.Runtime;


// Робит
public class App {
    public static void main ( String[] args) throws Exception {

        String command = args[0] + " " +  args[1];

        Process p = Runtime.getRuntime().exec(command);
    }
}