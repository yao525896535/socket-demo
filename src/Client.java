
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;

    public Client(){
        try {
            socket = new Socket("localhost",8848);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try {
            OutputStream outputStream= socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"UTF-8");
            PrintWriter printWriter = new PrintWriter(outputStreamWriter,true);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                printWriter.println(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
