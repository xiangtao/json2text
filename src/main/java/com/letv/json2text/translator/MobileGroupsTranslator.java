package com.letv.json2text.translator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.letv.json2text.MobileGroups;
import com.letv.json2text.util.JSONUtils;

public class MobileGroupsTranslator implements Translator {

	@Override
	public List<String> translate(List<String> lines) {
		List<String> results = new ArrayList<String>(lines.size());
		for (String json : lines) {
			MobileGroups  mobileGroups =  JSONUtils.fromJson(json, MobileGroups.class);
			String outstr = formtInfo(mobileGroups);
			results.add(outstr);
		}
		
		System.out.println("input:" + lines.size() + ",output:" + results.size());
		
		return results;
	}
	
	public  String formtInfo(MobileGroups  mobileGroups){
		String fiedDemi = "\001";
		StringBuilder sb = new StringBuilder();
		sb.append(drop_delim(mobileGroups.get_id().get$oid()));
		sb.append(fiedDemi);
		sb.append(drop_delim(mobileGroups.getModel()));
		sb.append(fiedDemi);
		sb.append(drop_delim(mobileGroups.getTitle()));
		sb.append(fiedDemi);
		sb.append(drop_delim(mobileGroups.getIs_default()));
		sb.append(fiedDemi);
		sb.append(drop_delim(mobileGroups.getDescription()));
		sb.append(fiedDemi);
		sb.append(drop_delim(mobileGroups.getStatus()));
		
		return sb.toString();
	}
	
	public String drop_delim(String str){
		if(StringUtils.isEmpty(StringUtils.trimToEmpty(str))){
			return "-";
		}
		return str.replaceAll("(\n|\r|\001)+", "");
	}
	
	public static void main(String[] args) {
		/*MobileGroupsTranslator tran = new MobileGroupsTranslator();
		List<String> lines = new ArrayList<String>();
		lines.add("{\"_id\": {\"$oid\": \"5540ea38de127654c077d031\"}}");
		System.out.println(tran.translate(lines));*/
	}
	

}
