import java.io.*;
import javax.swing.*;
public class FileCopy{
	public static void main(String[] args)throws Exception{
		String src = JOptionPane.showInputDialog(null,"��������Ҫ���Ƶ�Դ�ļ���ַ:");
		String tar = JOptionPane.showInputDialog(null,"��������Ҫ���Ƶ�Ŀ���ļ���ַ:");

		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(tar);
		/*
		int data;
		while((data = fis.read())!=-1){
			fos.write(data);
		}
		*/
		byte[] data = new byte[100<<20];//50mb
		int len;
		while((len = fis.read(data))!=-1){
			fos.write(data,0,len);
		}
		fis.close();
		fos.close();
	}
}