package com.letv.json2text.translator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.letv.json2text.SuperPhoneInfoBase;
import com.letv.json2text.SuperPhoneInfoOfObjGroupId;
import com.letv.json2text.util.FormatPhoneInfoUtils;

public class MobileTranslatorForCSV implements Translator{
	
	public static final String FIELD_TITLE="_id,imei,imei2,sn,meid,ui_version,software_version,hardware_version,head_code,motherboard_code,repair,product_date,shipping_date,pcb_sn,production_number,letv_part_number,plan_id,factory_part_number,sale_area,send_time,factory_delivery_time,factory,factory_delivery_id,activation_time,activation_halfhour_time,status,activation_halfhour_mobile,plan_create_username,plan_create_time,model,group_id,send_username,godown_entry_id,description,external_model";

	@Override
	public List<String> translate(List<String> lines) {
		List<String> results = new ArrayList<String>(lines.size());
		for (String line : lines) {
			//_id,imei,imei2,sn,meid,ui_version,software_version,hardware_version,head_code,motherboard_code,repair,product_date,shipping_date,pcb_sn,
			//production_number,letv_part_number,plan_id,factory_part_number,sale_area,send_time,factory_delivery_time,factory,factory_delivery_id,activation_time,
			//activation_halfhour_time,status,activation_halfhour_mobile,plan_create_username,plan_create_time,model,group_id,send_username,
			//godown_entry_id,description
			SuperPhoneInfoOfObjGroupId  phoneInfo =  new SuperPhoneInfoOfObjGroupId();
			//skip csv tile field
			if(FIELD_TITLE.equals(line)) continue;
			
			String[] lineArray = line.split(",");
			if(lineArray.length!=35) {
				System.out.println("line length is" + lineArray.length + " line is :" + line);
				//throw new RuntimeException("line length != 34");
				//临时解决这个字段中有 , 的这个问题: ObjectID(556817a3de12765ac5dfbd31)  
				if("ObjectID(556817a3de12765ac5dfbd31)".equals(lineArray[0])){
					//idx: 26 27
					String[] lineArrayCopy = new String[35];
					System.arraycopy(lineArray, 0, lineArrayCopy, 0, 26);
					lineArrayCopy[26]=",";
					System.arraycopy(lineArray, 28, lineArrayCopy, 27, 8);
					lineArray = lineArrayCopy;
					System.out.println("处理26idx有,的情况后:" + Arrays.asList(lineArray));
				}
			}
			
			for (int i = 0; i < lineArray.length; i++) {
				String str = lineArray[i];
				int idx = str.indexOf("ObjectID(");
				if(idx!=-1){
					str = str.substring( idx + 9,str.length()-1);
				}else{
					idx = str.indexOf("NumberLong(");
					if(idx!=-1){
						str = str.substring( idx + 11,str.length()-1);
					}
				}
				if(str.startsWith("\"") && str.endsWith("\"")){
					if(str.length()>1){
						str = str.substring(1,str.length()-1);
					}
				}
				
				
				if(i==0){
					SuperPhoneInfoBase.Id IdObj = new SuperPhoneInfoBase.Id();
					IdObj.set$oid(str);
					phoneInfo.set_id(IdObj);
				}else if(i==1){
					phoneInfo.setImei(str);
				}else if(i==2){
					phoneInfo.setImei2(str);
				}else if(i==3){
					phoneInfo.setSn(str);
				}else if(i==4){
					phoneInfo.setMeid(str);
				}else if(i==5){
					phoneInfo.setUi_version(str);
				}else if(i==6){
					phoneInfo.setSoftware_version(str);
				}else if(i==7){
					phoneInfo.setHardware_version(str);
				}else if(i==8){
					phoneInfo.setHead_code(str);
				}else if(i==9){
					phoneInfo.setMotherboard_code(str);
				}else if(i==10){
					phoneInfo.setRepair(str);
				}else if(i==11){
					phoneInfo.setProduct_date(str);
				}else if(i==12){
					phoneInfo.setShipping_date(str);
				}else if(i==13){
					phoneInfo.setPcb_sn(str);
				}else if(i==14){
					phoneInfo.setProduction_number(str);
				}else if(i==15){
					phoneInfo.setLetv_part_number(str);
				}else if(i==16){
					phoneInfo.setPlan_id(str);
				}else if(i==17){
					phoneInfo.setFactory_part_number(str);
				}else if(i==18){
					phoneInfo.setSale_area(str);
				}else if(i==19){
					phoneInfo.setSend_time(str);
				}else if(i==20){
					phoneInfo.setFactory_delivery_time(str);
				}else if(i==21){
					phoneInfo.setFactory(str);
				}else if(i==22){
					phoneInfo.setFactory_delivery_id(str);
				}else if(i==23){
					phoneInfo.setActivation_time(str);
				}else if(i==24){
					phoneInfo.setActivation_halfhour_time(str);
				}else if(i==25){
					phoneInfo.setStatus(str);
				}else if(i==26){
					phoneInfo.setActivation_halfhour_mobile(str);
				}else if(i==27){
					phoneInfo.setPlan_create_username(str);
				}else if(i==28){
					phoneInfo.setPlan_create_time(str);
				}else if(i==29){
					phoneInfo.setModel(str);
				}else if(i==30){
					SuperPhoneInfoOfObjGroupId.GroupId goupIdObj = new SuperPhoneInfoOfObjGroupId.GroupId();
					goupIdObj.set$oid(str);
					phoneInfo.setGroup_id(goupIdObj);
				}else if(i==31){
					phoneInfo.setSend_username(str);
				}else if(i==32){
					phoneInfo.setGodown_entry_id(str);
				}else if(i==33){
					phoneInfo.setDescription(str);
				}else if(i==34){
					phoneInfo.setExternal_model(str);
				}
			}
			String outstr = FormatPhoneInfoUtils.formtPhoneInfo(phoneInfo);
			results.add(outstr);
			
		}
		System.out.println("input:" + lines.size() + ",output:" + results.size());
		
		return results;
	}
	
	public static void main(String[] args) {
		MobileTranslatorForCSV mt = new MobileTranslatorForCSV();
		List<String> lines = new ArrayList<String>();
		//lines.add("ObjectID(55361f7ede12765057174fae),\"\",1430771668,NumberLong(5540ea38de127654c077d031)");
		//System.out.println(mt.translate(lines));
		
		
		String bugstr = "ObjectID(556817a3de12765ac5dfbd31),\"866479022338676\",\"866479022338676\",\"LP004364A5220019995\",\"86647902233867\",\"LL96.FAC.1.023.00\",\"ABXCNOP5000104271S\",\"BD\",\"600400002647\",\"504300002810\",\"0\",\"1432795442\",\"1432861570\",\"LE16A05180037133\",\"X600_280000_86647902216101_20150521114740\",\"600400002647\",\"20150521113115000001\",\"600400002647\",\"China Mainland\",\"\",\"1432867000\",\"CEI\",\"5567e1490641732010759749\",1433475374,1433482019,\"1\",\",\",\"\",\"\",\"X600\",ObjectID(5540ea38de127654c077d029),\"\",\"\",\"乐视超级手机1 通用版 3GB/16GB 银?白 双卡双待 LTE-TD-WCDMA-GSM 量产\",\"S1\"";
		String[] lineArray = bugstr.split(",");
		if(lineArray.length!=35) {
			String[] lineArrayCopy = new String[35];
			System.arraycopy(lineArray, 0, lineArrayCopy, 0, 26);
			lineArrayCopy[26]=",";
			System.arraycopy(lineArray, 28, lineArrayCopy, 27, 8);
			lineArray = lineArrayCopy;
			System.out.println(Arrays.asList(lineArray));
			
		}
		
	}

}
