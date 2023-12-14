package tcpSent;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class client{
    public static void main(String[] args) throws  IOException {
        //创建连接
        Socket socket=new Socket("127.0.0.1", 9999);
        //创建输出流
        OutputStream os=socket.getOutputStream();
        //输出数据
        os.write("hello".getBytes());
        socket.shutdownOutput();
        //关闭连接
        socket.close();
    }
}
