package com.zjj;

/**
 * 进制转换
 * @author ZJJ
 *
 */

public class BinHexOct {
	public static void main(String[] args) 
	{
		//toBin(-6);
		//toHex(-60);
		//toBa(60);
	}
	/**
	 * 十进制-->二进制 
	 * @param num
	 */
	public static void toBin(int num)
	{
		trans(num,1,1);
	}
	/**
	 * 十进制-->八进制
	 * @param num
	 */
	public static void toBa(int num)
	{
		trans(num,7,3);
	}
	/**
	 * 十进制-->十六进制
	 * @param num
	 */
	public static void toHex(int num)
	{
		trans(num,15,4);
	}

	public static void trans(int num,int base,int offset)
	{
		StringBuffer sb = new StringBuffer();
		if(num==0)
		{
			System.out.println(0);
			return ;
		}
		char[] chs = {'0','1','2','3'
					,'4','5','6','7'
					,'8','9','A','B'
					,'C','D','E','F'};
		while(num!=0)
		{
			int temp = num & base;
			sb.append(chs[temp]);
			num = num >>> offset;
		}
		System.out.println(sb.reverse().toString());
		return ;
	}
}
