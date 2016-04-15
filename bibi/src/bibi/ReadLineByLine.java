package bibi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ReadLineByLine {
	public static void ReadFile(String path){
		String regex = ",|\\s+";
//		int i = 0;
		try {
			File file = new File(path);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine())!=null){
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			List<String> stringArray = new ArrayList<String>();
			Collections.addAll(stringArray, stringBuffer.toString().split("\\s*(,|\\s)\\s*"));
			Collections.sort(stringArray);
			fileReader.close();
			System.out.println("Content of file:");
//			System.out.print(stringBuffer.toString());
			for(String e : stringArray){
//				System.out.print(i+e+"\n");
//				i++;
				WriteFile(e);
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void WriteFile(String content) throws IOException {
		File outputFile = new File("C:\\Users\\junyi\\Desktop\\aaaOUTPUT.txt");
		outputFile.createNewFile();
		FileWriter fileWriter = new FileWriter(outputFile, true);
		BufferedWriter out = new BufferedWriter(fileWriter);
		out.write(content+"\r\n");
		out.flush();
		out.close();
	}
	
	public static void main(String[] args){	
//		ReadFile("C:\\Users\\junyi\\Desktop\\aaa.txt");
		String x = ",afk o,op h , ll";
//		StringBuilder sb = new StringBuilder(x);
	
		List<String> sb = new ArrayList<String>(Arrays.asList(x.split("")));
//		System.out.println(x);
//		int j = sb.length();
//		for(int i = 0; i < j;i++){
//			if(sb.charAt(i) == ' '||sb.charAt(i) == ','){
//				System.out.println(j);
//				sb.deleteCharAt(i);
//				j--;
//				i--;
//			}
		int j = sb.size();
		for(int i = 0; i < j;i++){
//			System.out.print((sb.get(i).equals(" "))+"\n");
			if(sb.get(i).equals(" ")||sb.get(i).equals(",")){
				System.out.println(j);
				sb.remove(i);
				j--;
				i--;
			}
		}
//		sb.deleteCharAt(3);
		System.out.print(String.join("", sb));
	}
}