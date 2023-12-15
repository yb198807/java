package tcpSent;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class service {
    public static void main(String[] args) throws IOException {
        //创建服务端
        ServerSocket serverSocket=new ServerSocket(9999);
        //创建连接
        Socket socket = serverSocket.accept();
        //创建输入流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        //创建输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test/src/tcpSent/to/1.jpg"));
        //接收数据写入文件
        byte[] b=new byte[1024];
        int len;
        while((len=bis.read(b))!=-1) {
            bos.write(b,0,len);
        }
        //关闭连接
        socket.close();
        //关闭服务端
        serverSocket.close();
    }
}
