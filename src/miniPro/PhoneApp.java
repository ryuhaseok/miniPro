package miniPro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		//시작화면
		System.out.println("********************************************");
		System.out.println("*           전화번호 관리 프로그램         *");
		System.out.println("********************************************");
		
		
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			Reader fr = new FileReader("C:\\javaStudy\\workspace\\miniPro\\PhoneDB.txt");
			BufferedReader br = new BufferedReader(fr);
			
			List<Person> pList = new ArrayList<Person>();
			
			while(true) {
				
				String str = br.readLine();
				
				if(str == null) {
					break;
				}
				
				Person p = new Person();
				
				String[] info = str.split(",");
				
				p.setName(info[0]);
				p.setHp(info[1]);
				p.setCompany(info[2]);
				pList.add(p);
			}
			
			br.close();
			
			System.out.println("");
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("--------------------------------------------");
			System.out.print(">메뉴번호: ");
			
			int num = sc.nextInt();
			
			//리스트
			if(num == 1) {
				System.out.println("<1.리스트>");
				
				for(int i=0; i<pList.size(); i++) {
					System.out.println(i+1 + "." +"\t" + pList.get(i).getName() + "\t" + pList.get(i).getHp() + "\t" + pList.get(i).getCompany());
				}
				
				//등록
			} else if(num == 2) {
				System.out.println("<2.등록>");
				
				
				//이거 안 들어가면 왜그러는지 모르겠는데 이름 입력을 건너뜀
				System.out.print("");
				String d = sc.nextLine();
				//
				
				System.out.print(">이름: ");
				String name = sc.nextLine();
				
				
				System.out.print(">휴대전화: ");
				String hp = sc.nextLine();
				
				System.out.print(">회사전화: ");
				String company = sc.nextLine();
				
				Writer fw = new FileWriter("C:\\javaStudy\\workspace\\miniPro\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				
				Person p = new Person(name, hp, company);
				pList.add(p);
				
				for(int i=0; i<pList.size(); i++) {
					bw.write(pList.get(i).getName()+","+pList.get(i).getHp()+","+pList.get(i).getCompany());
					bw.newLine();
				}
				
				bw.close();
				System.out.println("[등록되었습니다.]");
				
				//삭제
			} else if(num == 3) {
				System.out.println("<3.삭제>");
				System.out.print(">번호 : ");
				int pNum = sc.nextInt();
				
				if(pNum <= pList.size()) {
					
					pList.remove(pNum-1);
				
					Writer fw = new FileWriter("C:\\javaStudy\\workspace\\miniPro\\PhoneDB.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					
					for(int i=0; i<pList.size(); i++) {
						bw.write(pList.get(i).getName()+","+pList.get(i).getHp()+","+pList.get(i).getCompany());
						bw.newLine();
					}
					
					bw.close();
					System.out.println("[삭제되었습니다.]");
				}
				
				//검색
			} else if(num == 4) {
				System.out.println("<4.검색>");
				//이거 안 들어가면 왜그러는지 모르겠는데 이름 입력을 건너뜀
				System.out.print("");
				String f = sc.nextLine();
				//
				System.out.print(">이름: ");
				String searchName = sc.nextLine();
				
				Reader fr2 = new FileReader("C:\\javaStudy\\workspace\\miniPro\\PhoneDB.txt");
				BufferedReader br2 = new BufferedReader(fr2);
				
				while(true) {
					String search = br2.readLine();
					
					if(search == null ) {
						break;
					}
					if( search.contains(searchName) == true ) {
						System.out.println(search);
						
					}
				
				}
				
				//종료
			} else if(num == 5) {
				System.out.println("********************************************");
				System.out.println("*                 감사합니다               *");
				System.out.println("********************************************");
				
				break;
				
				//없는메뉴
			} else {
				System.out.println("[다시 입력해 주세요.]");
			}
			
			
		}//while
		
		sc.close();
	}
}


