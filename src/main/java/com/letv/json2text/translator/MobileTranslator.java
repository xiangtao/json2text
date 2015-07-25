package com.letv.json2text.translator;

import java.util.ArrayList;
import java.util.List;

import com.letv.json2text.SuperPhoneInfoBase;
import com.letv.json2text.SuperPhoneInfoOfObjGroupId;
import com.letv.json2text.SuperPhoneInfoOfStringGroupId;
import com.letv.json2text.util.FormatPhoneInfoUtils;
import com.letv.json2text.util.JSONUtils;

public class MobileTranslator implements Translator{

	@Override
	public List<String> translate(List<String> lines) {
		List<String> results = new ArrayList<String>(lines.size());
		for (String json : lines) {
			SuperPhoneInfoBase  phoneInfo =  JSONUtils.fromJson(json, SuperPhoneInfoOfObjGroupId.class);
			String outstr = "";
			if(phoneInfo ==null){
				//try agine for string group_id
				System.out.println("try agine for string group_id");
				 phoneInfo = JSONUtils.fromJson(json, SuperPhoneInfoOfStringGroupId.class);
				 if(phoneInfo!=null){
					 System.out.println("try agine success");
				 }
			}
			if(phoneInfo !=null){
				outstr = FormatPhoneInfoUtils.formtPhoneInfo(phoneInfo);
				results.add(outstr);
			}else{
				System.out.println("json parse failed: " + json);
			}
		}
		System.out.println("input:" + lines.size() + ",output:" + results.size());
		
		return results;
	}

	public static void main(String[] args) {
		MobileTranslator mt = new MobileTranslator();
		List<String> lines = new ArrayList<String>();
		//lines.add("{\"group_id\": {\"$oid\": \"5540ea38de127654c077d031\"}}");
		//lines.add("{ \"_id\" : { \"$oid\" : \"55a5f0da23c6524109b52e57\" }, \"repair\" : \"0\", \"send_time\" : \"\", \"factory_delivery_time\" : \"1436937525\", \"head_code\" : \"504200002820\", \"letv_part_number\" : \"600400002809\", \"ui_version\" : \"BBXNAOP5009807011D-20150701-3-TEST-KEYS\", \"imei2\" : \"868126020001552\", \"plan_id\" : \"20150701161209000001\", \"factory_part_number\" : \"600400002809\", \"sale_area\" : \"North America\", \"shipping_date\" : \"1436889600\", \"factory\" : \"Pegatron\", \"factory_delivery_id\" : \"55a5ed35f0860d0a000917c5\", \"activation_time\" : \"\", \"motherboard_code\" : \"504300002892\", \"product_date\" : \"0\", \"pcb_sn\" : \"LEN8D05270000152\", \"description\" : \"Le 1 Pro 北美版 4GB/64GB 银 双卡双待 LTE-WCDMA-CDMA-GSM_DF10SI01\", \"software_version\" : \"5.0.2\", \"external_model\" : \"Le 1 Pro\", \"activation_halfhour_time\" : \"\", \"meid\" : \"86812602000154\", \"imei\" : \"868126020001545\", \"status\" : \"1\", \"activation_halfhour_mobile\" : \"\", \"hardware_version\" : \"x1_na_dvt1\", \"production_number\" : \"Le 1 Pro_200_86812602000000_20150701165016\", \"plan_create_username\" : \"\", \"plan_create_time\" : \"\", \"sn\" : \"LP016187D5280000130\", \"model\" : \"Le 1 Pro\", \"group_id\" : \"\", \"send_username\" : \"\", \"godown_entry_id\" : \"\" }");
		//lines.add("{\"group_id\" : \"\"}");
		System.out.println(mt.translate(lines));
	}
}
