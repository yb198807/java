package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send {
    public static void main(String[] args) throws IOException {
        //创建端口
        DatagramSocket ds = new DatagramSocket(9999);
        //打包数据
        byte[] data="你好啊".getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length,InetAddress.getByName("127.0.0.1"),9998);
        //发送数据
        ds.send(dp);
        //接收回复
        data=new byte[1024];
        dp=new DatagramPacket(data, data.length);
        ds.receive(dp);
        data=dp.getData();
        System.out.println(new String(data));
        //关闭连接
        ds.close();
    }
}
