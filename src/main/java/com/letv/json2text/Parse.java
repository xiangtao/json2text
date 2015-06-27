package com.letv.json2text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.letv.json2text.translator.Translator;
import com.letv.json2text.translator.TranslatorFactory;
import com.letv.json2text.util.FileUtils;

public class Parse {

	public static void main(String[] args) {
		String inputFile = null;
		String outputFile = null;
		String translator = "";
		if(args == null || args.length!=3){
			System.out.println("args must be two <inputFile> <outputFile> <translator>");
			System.exit(-1);
		}else{
			inputFile = args[0];
			outputFile = args[1];
			translator = args[2];
		}
		
		try {
			long st = System.currentTimeMillis();
			System.out.println(new Date() + ":start to parse json" + " inputFile:" + inputFile + " outputFile:" + outputFile + " translator:" + translator);
			Translator translatorObj = TranslatorFactory.getTranslator(translator);
			if(translatorObj == null ) throw new RuntimeException("no translator find for: " + translator);
			
			readLinesAndParse(new File(inputFile),new File(outputFile),translatorObj);
			
			
			System.out.println(new Date() + ":end parse");
			System.out.println("parse total time: " + (System.currentTimeMillis() - st) + " ms");
		} catch (IOException e) {
			System.err.println("parse error" + e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	
	public static void readLinesAndParse(File inputFile,File outFile,Translator translatorObj) throws IOException{
		if(inputFile == null || outFile == null) return;
		BufferedReader reader = null;
		List<String> lines = new ArrayList<String>();
		int valve = 10000;
		try {
			int cout = 0;
			reader = new BufferedReader(new FileReader(inputFile));
			String line = reader.readLine();
			while(line!=null){
				cout++;
				lines.add(line);
				if(cout>=valve){
					doParseAndWrite(lines,outFile,translatorObj);
					cout=0;
					lines.clear();
				}
				line = reader.readLine();
			}
			if(!lines.isEmpty()){
				doParseAndWrite(lines,outFile,translatorObj);
			}
		}finally{
			if(reader!=null)reader.close();
		}
	}
	
	private static void doParseAndWrite(List<String> lines,File outFile,Translator translatorObj) throws IOException {
		List<String>  results = translatorObj.translate(lines);
		FileUtils.appendValuesToFile(results, outFile);
	}
	
}
