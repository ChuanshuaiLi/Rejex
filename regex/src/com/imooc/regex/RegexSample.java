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
			//�ļ����������ó������������
			FileInputStream fis = new FileInputStream("/Users/lcs/eclipse-j2ee-workspace/regex/WebContent/sample.html");
			//��������������ַ����������ַ���
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
			//���뻺����ƣ���߶�ȡЧ��
			BufferedReader bufferedReader = new BufferedReader(isr);
			//����ÿһ�е�����
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
		
		//1.����������ʽ���󣬴���һ��������ʽ�ַ���
		Pattern p = Pattern.compile("<li>([\\u4e00-\\u9fa5]{2,10})([a-zA-Z]+)</li>");
		//2.ƥ��������ʽ
		Matcher m = p.matcher(content);
		//3.����ƥ��Ľ��
		while(m.find()) {
			//group(0)��Ӧ����
//			System.out.println(m.group(0));
			//group(n),n�����n������
			String chs = m.group(1);
			String eng = m.group(2);
			System.out.println(chs + "-" + eng);
		}
	}
}
