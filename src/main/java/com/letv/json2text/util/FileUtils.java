package com.letv.json2text.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 文件工具类
 * @author xiangtao
 * @createTime 2013-4-11
 */
public class FileUtils {
	 
	
	public static String getFirstFilePathInDir(String dir,final String suffex,Comparator<File> comparator){
		if(dir==null)  throw new NullPointerException("dir must not be null");
		File dirc = new File(dir);
		if(!dirc.exists() || !dirc.isDirectory()){
			throw new IllegalArgumentException("dir must be exists directory");
		}
		String rtn = null;
		File[] files = dirc.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if(pathname.isDirectory()||(!(pathname.getName().endsWith(suffex)))){
					return false;
				}
				return true;
			}
		});
		if(files!=null&&files.length>0){
			Arrays.sort(files,comparator);
			File file = files[0];
			rtn = file.getAbsolutePath();
		}
		return rtn;
	}
	
	
	
	public static File[] getFilesByRegxFileName(String dir,final String regxName){
		if(dir==null)  throw new NullPointerException("dir must not be null");
		File dirc = new File(dir);
		if(!dirc.exists() || !dirc.isDirectory()){
			throw new IllegalArgumentException("dir must be exists directory");
		}
		File[] files = dirc.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				Pattern pattern = Pattern.compile(regxName);
				Matcher matcher = pattern.matcher(pathname.getName());
				if(pathname.isDirectory()||(!(matcher.find()))){
					return false;
				}
				return true;
			}
		});
		return files;
	}
	
	
	public static boolean deleteFile(String filePath){
		if(filePath==null)  throw new NullPointerException("filePath must not be null");
		boolean r = false;
		File f = new File(filePath);
		if(f.exists()){
			r = f.delete();
		}
		return r;
	}
	
	public static void renameFile(File file,String newName){
		if(file==null)  throw new NullPointerException("file must not be null");
		if(!file.isFile() || !file.exists()) throw new IllegalArgumentException("file must not be a file and exists");
		File newFile = new File(file.getParent()+"/" + newName);
		file.renameTo(newFile);
	}
	
	
	
	/**
	 * 写value,覆盖原来的值
	 * @param value
	 * @throws IOException 
	 */
	public static void writeValueToFile(String value,File file) throws IOException{
		if(value==null||file == null) return;
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			writer.write(value);
		}finally{
			if(writer!=null)writer.close();
		}
	}
	
	public static void appendValueToFile(String value,File file) throws IOException{
		if(value==null||file == null) return;
		BufferedWriter  writer = null;
		try {
			writer = new BufferedWriter(new FileWriter (file,true));
			writer.write(value);
			writer.newLine();
		}finally{
			if(writer!=null)writer.close();
		}
	}
	
	public static void appendValuesToFile(List<String> values,File file) throws IOException{
		if(values==null||file == null) return;
		BufferedWriter  writer = null;
		try {
			writer = new BufferedWriter(new FileWriter (file,true));
			for (String value : values) {
				writer.write(value);
				writer.newLine();
			}
		}finally{
			if(writer!=null)writer.close();
		}
	}
	
	
	/**
	 * 安行读取文件内容
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static List<String> readLinesFromFile(File file) throws IOException{
		if(file == null) return null;
		BufferedReader reader = null;
		List<String> lines = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while(line!=null){
				lines.add(line);
				line = reader.readLine();
			}
			return lines;
		}finally{
			if(reader!=null)reader.close();
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
//		String dir = "E:\\letv\\直播平台\\coverttemp";
//		System.out.println(getFirstFilePathInDir(dir,"seq"));
//		File f =new File("E:\\letv\\直播平台\\coverttemp\\20130304-1820.seq");
//		renameFile(f, "20130304-1820.seq.lock");
//		File f =new File("E:/jar/test1/mysql-connector-java-5.1.9.jar");
//		moveFile(f, new File(f.getParent() + "/backup"));
		long startTime = System.currentTimeMillis();
//		File t1 =new File("F:/program-soft/OS/linux/centos/CentOS-6.4-x86_64-bin-DVD1to2/CentOS-6.4-x86_64-bin-DVD1.iso");
		File t2 =new File("F:/program-soft/OS/linux/centos/CentOS-6.4-x86_64-bin-DVD1to2/CentOS-6.4-x86_64-bin-DVD2.iso");
//		File t3 =new File("F:/program-soft/OS/linux/centos/CentOS-6.4-i386-bin-DVD1to2/CentOS-6.4-i386-bin-DVD1.iso");
		
		File dest =new File("E:/letv/livep/test/test2.txt");
		File[] ts = new File[]{t2};
		
		File destFile = new File("F:/program-soft/OS/linux/centos/CentOS-6.4-x86_64-bin-DVD1to2/centos.os");
		if(!destFile.exists()){
//			destFile.mkdirs();
		}
//		copyMerge(ts, destFile, false);
		
		long endTime = System.currentTimeMillis();
		System.out.println("upload completed,sum upload time :" + ((endTime - startTime))+"ms");
		
		
		
		File[] f = getFilesByRegxFileName("E:/letv/livep/test", "te");
		System.out.println(f[0].getAbsolutePath());
		
		Pattern pattern = Pattern.compile("te");
		Matcher matcher = pattern.matcher("test1");
		
		System.out.println(matcher.matches() + "fffff");
		
		System.err.println(matcher.find());
		
		System.out.println("test1".matches("te") + "xxxx");
		
		
		File file = new File("E:/letv/livep/test/waiting.sche");
		FileUtils.writeValueToFile("", file); //firstly clear file content
		FileUtils.appendValueToFile("xxxxxxxxxxx", file);
		FileUtils.appendValueToFile("1111111111111", file);
		
		List<String> scheStrList = FileUtils.readLinesFromFile(file);
		System.out.println(scheStrList.size());
		
	   AtomicInteger activedSchedulerNumb= new AtomicInteger(0);; //活动调度任务数
	   activedSchedulerNumb.addAndGet(2);
	   System.out.println(activedSchedulerNumb.get());
	   activedSchedulerNumb.addAndGet(-1); //completed -1
	   System.out.println(activedSchedulerNumb.get());
	}

}
