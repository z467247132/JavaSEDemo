package com.zjj;

import java.awt.im.InputContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpService {

	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket s = null;
		try {
			
				ss = new ServerSocket(10004);
				s = ss.accept();
				InputStream in = s.getInputStream();
				String ip = s.getInetAddress().getHostAddress();
				System.out.println("ip:"+ip+"发来消息");
				byte[] buf = new byte[1024];
				int len = in.read(buf);
				System.out.println(new String(buf,0,len));
				OutputStream out = s.getOutputStream();
				out.write("收到了，响应".getBytes());
				s.close();
				ss.close();
			
		} catch (IOException e) {
			System.out.println("数据传输失败"+e.getMessage());
		}
	}

}
