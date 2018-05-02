package com.zjj;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceDemo {
	/*
	需求：
	定义一个应用程序，用于接收udp协议传输的数据并处理的。


	定义udp的接收端。
	思路：
	1，定义udpsocket服务。通常会监听一个端口。其实就是给这个接收网络应用程序定义数字标识。
		方便于明确哪些数据过来该应用程序可以处理。

	2，定义一个数据包，因为要存储接收到的字节数据。
	因为数据包对象中有更多功能可以提取字节数据中的不同数据信息。
	3，通过socket服务的receive方法将收到的数据存入已定义好的数据包中。
	4，通过数据包对象的特有功能。将这些不同的数据取出。打印在控制台上。
	5，关闭资源。

	*/


	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(10000);
			byte[] buf = new byte[1024];
			ds.receive(new DatagramPacket(buf, buf.length));
			System.out.println(new String(buf));
		} catch (SocketException e) {
			System.out.println("监听超时");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			ds.close();
		}
	}

}
