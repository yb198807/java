package tcpSent;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class service {
    public static void main(String[] args) throws IOException {
        //创建服务端
        ServerSocket serverSocket=new ServerSocket(9999);
        //创建连接
        Socket socket = serverSocket.accept();
        //创建输入流（字节流）
        InputStream is=socket.getInputStream();
        //接收数据
        int b;
        while((b=is.read())!=-1) {
            System.out.print((char)b);
        }
        //关闭连接
        socket.close();
        //关闭服务端
        serverSocket.close();
    }
}
