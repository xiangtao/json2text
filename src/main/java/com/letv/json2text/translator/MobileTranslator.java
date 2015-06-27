package com.letv.json2text.translator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.letv.json2text.SuperPhoneInfo;
import com.letv.json2text.util.JSONUtils;

public class MobileTranslator implements Translator{

	@Override
	public List<String> translate(List<String> lines) {
		List<String> results = new ArrayList<String>(lines.size());
		for (String json : lines) {
			SuperPhoneInfo  phoneInfo =  JSONUtils.fromJson(json, SuperPhoneInfo.class);
			String outstr = "";
			if(phoneInfo !=null){
				outstr = formtPhoneInfo(phoneInfo);
				results.add(outstr);
			}else{
				System.out.println("json parse failed: " + json);
			}
		}
		System.out.println("input:" + lines.size() + ",output:" + results.size());
		
		return results;
	}
	
	
	private  String formtPhoneInfo(SuperPhoneInfo  phoneInfo){
		String fiedDemi = "\001";
		StringBuilder sb = new StringBuilder();
		sb.append(drop_delim(phoneInfo.get_id().get$oid()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getImei()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getImei2()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getSn()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getMeid()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getUi_version()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getSoftware_version()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getHardware_version()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getHead_code()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getMotherboard_code()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getRepair()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getProduct_date()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getShipping_date()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getPcb_sn()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getProduction_number()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getLetv_part_number()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getPlan_id()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getFactory_part_number()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getSale_area()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getSend_time()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getFactory_delivery_time()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getFactory()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getFactory_delivery_id()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getActivation_time()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getActivation_halfhour_time()));
		sb.append(fiedDemi);
		/*sb.append(drop_delim(phoneInfo.getFactory_send_date()));
		sb.append(fiedDemi);*/
		sb.append(drop_delim(phoneInfo.getStatus()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getActivation_halfhour_mobile()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getPlan_create_username()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getPlan_create_time()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getModel()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getGroup_id()==null?"":phoneInfo.getGroup_id().get$oid()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getSend_username()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getGodown_entry_id()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getDescription()));
		sb.append(fiedDemi);
		sb.append(drop_delim(phoneInfo.getExternal_model()));
		return sb.toString();
	}
	
	public String drop_delim(String str){
		if(StringUtils.isEmpty(StringUtils.trimToEmpty(str))){
			return "-";
		}
		return str.replaceAll("(\n|\r|\001)+", "");
	}

	public static void main(String[] args) {
		/*MobileTranslator mt = new MobileTranslator();
		List<String> lines = new ArrayList<String>();
		lines.add("{\"group_id\": {\"$oid\": \"5540ea38de127654c077d031\"}}");
		System.out.println(mt.translate(lines));*/
	}
}
