package jeca.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * 텍스트 파일로부터 텍스트 데이터를 읽어오거나 쓸 때 사용할 클래스. 
 * 기존의 파일 입출력 스트림 객체 코드를 모듈화하여 
 * 코드를 간결하게 하고 재사용성을 높이고자 만듦. 
 * 
 * <div>
 * 제작자 정보
 * <ul>
 * <li>
 * <a href="https://github.com/JeroCaller">Author's Github</a>
 * </li>
 * <li>
 * <a href="https://jerocaller.github.io">Author's blog</a>
 * </li>
 * </div>
 * 
 * @author JeroCaller
 */
public class TextFileIO {
	private String pathForWrite = null;
	private String pathForRead = null;
	
	/**
	 * 데이터를 쓸 텍스트 파일 경로 지정.
	 * @param pathForWrite - 데이터를 쓸 텍스트 파일 경로 지정.
	 */
	public void setPathForWrite(String pathForWrite) {
		this.pathForWrite = pathForWrite;
	}
	
	/**
	 * 데이터를 읽어올 텍스트 파일 경로 지정.
	 * @param pathForRead - 데이터를 읽어올 텍스트 파일 경로 지정.
	 */
	public void setPathForRead(String pathForRead) {
		this.pathForRead = pathForRead;
	}
	
	/**
	 * 지정된 경로의 텍스트 파일에 텍스트 데이터를 쓴다. 
	 * 이 메서드를 사용하기 전 반드시 {@link #setPathForWrite(String)} 
	 * 메서드를 이용하여 해당 텍스트 파일 경로를 지정해둬야 한다. 
	 * 
	 * @param text - 텍스트 파일에 쓸 문자열 형태의 텍스트.
	 * @param append - 기존 텍스트 파일 내용 뒤에 이어쓸지 아니면 새로 덮어쓸지 결정.
	 * <ul>
	 * <li> 
	 *     true : 기존 텍스트 파일 내용 뒤에 이어쓴다.
	 * </li>
	 * <li>
	 * 	   false : 기존 텍스트 파일 내용을 모두 지우고 새 텍스트 작성.
	 * </li>
	 * @return
	 * <ul>
	 * <li> 
	 *     true : 텍스트 파일에 쓰기 작업이 성공한 경우. 
	 * </li>
	 * <li>
	 * 	   false : 텍스트 파일에 쓰기 작업이 모종의 이유로 실패한 경우.
	 * </li>
	 */
	public boolean writeText(String text, boolean append) {
		
		/*
		 * try ~ with ~ resource 구문
		 * try 바로 옆에 괄호(())를 작성하고, 그 안에 입출력 스트림 객체를 생성하면 
		 * try ~ catch 문을 벗어나면 자동으로 close() 메서드를 호출해주므로
		 * 개발자가 따로 close() 메서드를 호출하는 번거로움을 없애줌.
		 */
		try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(pathForWrite, append))) {
			bufWriter.write(text + "\n");
		} catch (IOException exp) {
			handleIOException(exp);
			return false;
		}
		return true;
	}
	
	/**
	 * 특정 텍스트 파일 내 데이터를 읽어와 반환한다. 
	 * 이 메서드를 사용하기 전 반드시 {@link #setPathForRead(String)} 
	 * 메서드를 이용하여 해당 텍스트 파일 경로를 지정해둬야 한다.
	 * 
	 * @param createFileIfNotExists - 만약 해당 파일을 발견하지 못한 경우, 빈 새 텍스트 
	 * 파일을 생성할 지 여부.
	 * <ul>
	 * <li> 
	 *     true : 새 텍스트 파일을 생성. 이 때 경로는 {@link #setPathForRead(String)} 
	 *     메서드로 설정한 경로를 따른다. 
	 * </li>
	 * <li>
	 * 	   false : 새 텍스트 파일을 생성하지 않는다. 
	 * </li>
	 * @return - 읽어온 텍스트를 문자열로 반환. 만약 읽어온 데이터가 없으면 null을 반환. 
	 */
	public String readText(boolean createFileIfNotExists) {
		StringBuilder strBuilder = new StringBuilder();
		
		try (BufferedReader bufReader = new BufferedReader(new FileReader(pathForRead))) {
			String oneLine = null;
			while(true) {
				oneLine = bufReader.readLine();
				
				if (oneLine == null) {
					break;
				}
				
				strBuilder.append(oneLine + "\n");
			}
			
		} catch (IOException exp) {
			if (exp instanceof FileNotFoundException) {
				System.out.println("해당 경로에서 파일을 읽어올 수 없었습니다.");
				System.out.println("설정 경로: " + pathForRead);
				if (createFileIfNotExists) {
					System.out.println("해당 경로에 새 파일을 생성하였습니다.");
					createEmptyFile(pathForRead);
				}
			} else {
				handleIOException(exp);
			}
			
			return null;
		}
		return strBuilder.toString();
	}
	
	private void handleIOException(IOException exp) {
		System.out.println("파일 입출력 관련 에러 발생");
		exp.printStackTrace();
	}
	
	/**
	 * 주어진 경로에 내용이 비어 있는 새 텍스트 파일을 생성한다. 
	 * 
	 * @param path - 새 텍스트 파일을 생성할 경로 (파일명 포함)
	 * @return
	 * <ul>
	 * <li> 
	 *     true : 새 텍스트 파일 생성에 성공한 경우. 
	 * </li>
	 * <li>
	 * 	   false : 이미 해당 텍스트 파일이 존재하거나 예외가 발생하여 
	 * 새 텍스트 파일 생성을 하지 않은 경우. 
	 * </li>
	 */
	public boolean createEmptyFile(String path) {
		File f = new File(path);
		boolean created = false;
		try {
			if (!f.exists()) {
				created = f.createNewFile();
			}
		} catch (IOException exp) {
			handleIOException(exp);
		}
		return created;
	}
	
}
