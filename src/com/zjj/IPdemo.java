package com.zjj;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPdemo {

	public static void main(String[] args) throws Exception {
		InetAddress i = InetAddress.getByName("www.baidu.com");//创建InetAddress对象
		System.out.println(i.getHostAddress());//获取IP地址常用方法
		System.out.println(i.getHostName());
	}

}
