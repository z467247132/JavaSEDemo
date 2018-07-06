package com.zjj;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class SendMessage2 {

	public static void main(String[] args) {
		URL postUrl = null;
		//报文
		String content ="001X11          0000025659505B5885D885A36AC0C6089E361D5BCC75F88F95BEE2BDC1B15007F53EFE01C82EC7DEE803A4D928F60412171752DD778E005E2638F4F73B6F6286B10E2191415DABC9C908BA3446FEA199CB30514794DC355DF92993FAD28705BB87228BF4BDF117642F19B594B88A626E667BAB51AA0C5964D5E6F454DB6C368570FA2678<?xml version=\"1.0\" encoding=\"UTF-8\"?><Document><header><channelCode>GHB</channelCode><channelFlow>OGW01201804181005735790</channelFlow><channelDate>20180418</channelDate><channelTime>153254</channelTime><encryptData></encryptData></header><body><TRANSCODE>OGW00237</TRANSCODE><XMLPARA>f1NIfBMHRV/xjFWHDnGaS6TPT2Ou36wSFrTYItPg6pgKUrX4goSXbx3UIGjvdS0LiFbL2/CK8/xV04HQau01AnS8VeSNiSNO9zQsTuVV8xpSfUnm5VBLcYqr9P4LhY51m+Vuwvf0cqzJlwVTgjGo3BsvMNh/234lrd1KTqgzZ0PgWZaRQ2Qm3CLk8La13VCR2Via1xHp3k2gPOTT80OhF0tJigSoWpb7nED8tlo14JBK7CxQjOsqvjg490YpojYw</XMLPARA></body></Document>";
		try {
			//content为加密签名后的报文
			postUrl = new URL("http://116.24.103.46:801/Notify"); //URL请求地址
			HttpURLConnection urlcon =  (HttpURLConnection) postUrl.openConnection();
			int contentLength = content.getBytes().length;  //获取报文长度
			urlcon.setConnectTimeout(1000*15);
			urlcon.setReadTimeout(1000*60*2);
			urlcon.setRequestMethod("POST");  //post请求方式
			urlcon.setUseCaches(false);       //post请求不能使用缓存
			urlcon.setRequestProperty("Content-Length", String.valueOf(contentLength));
			urlcon.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			urlcon.setDoInput(true);  //默认为true
			urlcon.setDoOutput(true); //默认为true
			//urlcon.connect();       //urlcon.getOutputStream()会隐含的进行connect();
			DataOutputStream output =  new DataOutputStream(urlcon.getOutputStream());
			output.writeBytes(content);
			output.flush();
			output.close();
			
			BufferedReader buffer =new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
			StringBuffer strBuffer = new StringBuffer();
			String str = null;
			while((str=buffer.readLine())!=null){
				strBuffer.append(str);
			}
			System.out.println("返回报文为： "+strBuffer);
			buffer.close();
			urlcon.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//请第三方公司去完善
		}
	}

}
