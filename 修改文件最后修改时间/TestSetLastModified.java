import java.io.*;
public class TestSetLastModified{
	//�޸��ļ�����޸�ʱ�䡣(�ܸо���仰�е��ƿ�=-=)
	public static void main(String[] args)throws Exception{
		File file = new File("E:\\one.txt");	//�޸ĵ��ļ���·��
		long time = System.currentTimeMillis();
		//System.out.println(time);
		file.setLastModified(time-3653L*24*60*60*1000);	//�޸�Ϊʮ��֮ǰ
	}
}

