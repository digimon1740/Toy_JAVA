import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FileSender {
	public static void main(String ar[]) throws IOException{
		Scanner sc=new Scanner(System.in);

		System.out.println("");
		String ip=sc.next();
		InetAddress ia=InetAddress.getByName(ip);
		System.out.println("");
		String filename=sc.next();

		File file=new File(filename);
		if(!file.exists()){
			System.err.println("");
			System.exit(-1);
		}
		DatagramSocket ds=new DatagramSocket();
		DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream(file)));

		while(true){
			byte[] by=new byte[512];
			int x=dis.read(by, 0, by.length);
			if(x==-1)break;
			DatagramPacket dp=new DatagramPacket(by,x,ia,8888);
			ds.send(dp);
		}
		ds.close();
		System.out.println("");



	}
}
