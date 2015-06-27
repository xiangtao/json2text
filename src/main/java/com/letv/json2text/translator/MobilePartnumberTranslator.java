package com.letv.json2text.translator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.letv.json2text.MobilePartnumber;
import com.letv.json2text.util.JSONUtils;

public class MobilePartnumberTranslator implements Translator {

	@Override
	public List<String> translate(List<String> lines) {
		List<String> results = new ArrayList<String>(lines.size());
		for (String json : lines) {
			MobilePartnumber  mobilePartnumber =  JSONUtils.fromJson(json, MobilePartnumber.class);
			String outstr = formtInfo(mobilePartnumber);
			results.add(outstr);
		}
		System.out.println("input:" + lines.size() + ",output:" + results.size());
		return results;
	}
	
	public  String formtInfo(MobilePartnumber  mobilePartnumber){
		String fiedDemi = "\001";
		StringBuilder sb = new StringBuilder();
		sb.append(drop_delim(mobilePartnumber.getLetv_part_number()));
		sb.append(fiedDemi);
		sb.append(drop_delim(mobilePartnumber.getFactory_part_number()));
		sb.append(fiedDemi);
		sb.append(drop_delim(mobilePartnumber.getFactory()));
		sb.append(fiedDemi);
		sb.append(drop_delim(mobilePartnumber.getModel()));
		sb.append(fiedDemi);
		sb.append(drop_delim(mobilePartnumber.getDescription()));
		
		return sb.toString();
	}
	
	public String drop_delim(String str){
		if(StringUtils.isEmpty(StringUtils.trimToEmpty(str))){
			return "-";
		}
		return str.replaceAll("(\n|\r|\001)+", "");
	}

}
