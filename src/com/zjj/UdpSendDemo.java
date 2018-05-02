package com.zjj;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpSendDemo {

	/*
	需求：通过udp传输方式，将一段文字数据发送出去。，
	定义一个udp发送端。
	思路：
	1，建立updsocket服务。
	2，提供数据，并将数据封装到数据包中。
	3，通过socket服务的发送功能，将数据包发出去。
	4，关闭资源。

	*/
	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			 ds = new DatagramSocket();
			byte[] buf = "你是一个大蠢蛋".getBytes();
			ds.send(new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 10000));
		} catch (SocketException e) {
			System.out.println("建立socket超时"+e.toString());
		} catch (UnknownHostException e) {
			System.out.println("未知主机"+e.toString());
		} catch (IOException e) {
			System.out.println("IO流错误");
		}finally {
			ds.close();
		}
		
	}

}
