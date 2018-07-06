package com.zjj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClicent {

	public static void main(String[] args) throws IOException {
		Socket s = null;
		try {
			s = new Socket(InetAddress.getByName("localhost"), 10004);
			OutputStream out = s.getOutputStream();
//			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
//			String line = null;
//			while((line=buf.readLine())!=null){
//				byte[] buffer = line.getBytes();
//				out.write(buffer);
//			}
			out.write("我来了".getBytes());
			InputStream in = s.getInputStream();
			byte[] bufer = new byte[1024];
			int len = in.read(bufer);
			System.out.println(new String(bufer,0,bufer.length));
		} catch (IOException e) {
			System.out.println("传输数据失败:"+e.getMessage());
		}finally{
			s.close();
		}
	}

}
