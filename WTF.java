import java.io.*;
public class WTF{
	public static void main(String[] args)throws Exception{
		st:for(int i = 0;i < 9999;i++){
			String password = i + "";
			while(password.length()<4){
				password = "0" + password;
			}
			System.out.print("\r���ڳ��ԣ�"+password);	//\r �� return ����ǰ�е�����ߡ�
			Process p = Runtime.getRuntime().exec("rar x -p" + password + " hacker.rar .");	//��ѹ�ļ��õ����·��  "."��ʾ��ѹ����ǰĿ¼
			p.waitFor();

			InputStream is = p.getInputStream();	//�õ�process�ı�׼������
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String str;
			while((str = br.readLine())!=null){
				if(str.contains("����")){
					System.out.println();
					System.out.println("��ȷ���룺"+password);
					break st;	//goto���
				}
			}
			br.close();

		}
	}
}