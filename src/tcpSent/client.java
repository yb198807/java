package tcpSent;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class client{
    public static void main(String[] args) throws  IOException {
        //创建连接
        Socket socket=new Socket("127.0.0.1", 9999);
        //读取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("test/src/tcpSent/src/1.jpg"));
        //创建输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //输出数据
        byte[] b=new byte[1024];
        int len;
        while((len=bis.read(b))!=-1){
            bos.write(b,0,len);
        }
        socket.shutdownOutput();
        //关闭连接
        socket.close();
    }
}
