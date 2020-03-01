
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private ServerSocket serverSocket;

    public Server(){
        try {
            serverSocket = new ServerSocket(8848);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            System.out.println("等待客户端连接...");
            Socket socket = serverSocket.accept();  //从队列中取出连接请求
            System.out.println("客户端连接成功！");
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true){
                System.out.println("客户端说:" + bufferedReader.readLine());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server= new Server();
        server.start();
    }

}
