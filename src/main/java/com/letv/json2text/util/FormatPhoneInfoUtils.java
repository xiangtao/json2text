package com.letv.json2text.util;

import org.apache.commons.lang.StringUtils;

import com.letv.json2text.SuperPhoneInfoBase;
import com.letv.json2text.SuperPhoneInfoOfObjGroupId;
import com.letv.json2text.SuperPhoneInfoOfStringGroupId;

public class FormatPhoneInfoUtils {
	
	public  static String formtPhoneInfo(SuperPhoneInfoBase  phoneInfo){
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
		
		if(phoneInfo instanceof SuperPhoneInfoOfObjGroupId){
			SuperPhoneInfoOfObjGroupId phoneInfoForObjGroupId = (SuperPhoneInfoOfObjGroupId)phoneInfo;
			sb.append(drop_delim(phoneInfoForObjGroupId.getGroup_id()==null?"":phoneInfoForObjGroupId.getGroup_id().get$oid()));
		}else{
			SuperPhoneInfoOfStringGroupId phoneInfoForStringGroupId = (SuperPhoneInfoOfStringGroupId)phoneInfo;
			sb.append(drop_delim(phoneInfoForStringGroupId.getGroup_id()==null?"":phoneInfoForStringGroupId.getGroup_id()));
		}
		
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
	
	
	public static String drop_delim(String str){
		if(StringUtils.isEmpty(StringUtils.trimToEmpty(str))){
			return "-";
		}
		return str.replaceAll("(\n|\r|\001)+", "");
	}
}
