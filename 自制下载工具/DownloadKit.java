import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
public class DownloadKit{
	JFrame frame;//����
	JTextField jtf;//�����ı���
	JButton bt;//��ť
	JProgressBar jpb;//������
	public DownloadKit(){
		frame = new JFrame("����Ѹ��");
		jtf = new JTextField();
		jtf.setFont(new Font("����",1,20));
		bt = new JButton("��ʼ����");
		bt.addActionListener(new DownloadListener());
		jpb = new JProgressBar();
		jpb.setStringPainted(true);
		jpb.setFont(new Font("����",1,20));
		frame.add(jtf);
		frame.add(bt,"East");
		frame.add(jpb,"South");
		frame.setSize(400,100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);

	}
	public static void main(String[] args){
		new DownloadKit();
	}
	class DownloadListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae){
			new DownloadThread().start();
		}
	}
	class DownloadThread extends Thread{
		@Override
		public void run(){
			try{
				String target = jtf.getText();
				URL url = new URL(target);
				URLConnection uc = url.openConnection();
				//�õ�Ŀ����ܹ���С
				int total = uc.getContentLength();
				InputStream is = uc.getInputStream();
				String mb = target.substring(target.lastIndexOf("/")+1);
				OutputStream os = new FileOutputStream(mb);
				byte[] data = new byte[65536];
				int len;
				int current = 0;
				while((len = is.read(data))!=-1){
					os.write(data,0,len);
					current += len;
					int percent = current *100 / total;
					jpb.setValue(percent);
				}
				is.close();
				os.close();
				JOptionPane.showMessageDialog(frame,"Congratulations:"+mb+"�������");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}