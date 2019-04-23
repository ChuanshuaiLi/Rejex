package com.imooc.regex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSample {
	public static void main(String[] args) {
		StringBuilder content = new StringBuilder();
		try {
			//文件输入流，擅长处理二进制流
			FileInputStream fis = new FileInputStream("/Users/lcs/eclipse-j2ee-workspace/regex/WebContent/sample.html");
			//将二进制流变成字符，并设置字符集
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
			//引入缓冲机制，提高读取效率
			BufferedReader bufferedReader = new BufferedReader(isr);
			//保存每一行的数据
			String lineText = "";
			while((lineText = bufferedReader.readLine()) != null) {
//				System.out.println(lineText);
				content.append(lineText + "\n");
			}
			bufferedReader.close();
			//System.out.println(content);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//1.创建正则表达式对象，传入一个正则表达式字符串
		Pattern p = Pattern.compile("<li>([\\u4e00-\\u9fa5]{2,10})([a-zA-Z]+)</li>");
		//2.匹配正则表达式
		Matcher m = p.matcher(content);
		//3.查找匹配的结果
		while(m.find()) {
			//group(0)对应完整
//			System.out.println(m.group(0));
			//group(n),n代表第n个分组
			String chs = m.group(1);
			String eng = m.group(2);
			System.out.println(chs + "-" + eng);
		}
	}
}
