package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Receive {
    public static void main(String[] args) throws IOException {
        //创建端口
        DatagramSocket ds = new DatagramSocket(9998);
        //准备容器
        byte[] data=new byte[1024];
        DatagramPacket dp = new DatagramPacket(data, data.length);
        //接收数据
        ds.receive(dp);
        data=dp.getData();
        System.out.println(new String(data));
        //回复数据
        data="你也好".getBytes();
        dp=new DatagramPacket(data, data.length,InetAddress.getByName("127.0.0.1"),9999);
        ds.send(dp);
        //关闭连接
        ds.close();
    }
}
