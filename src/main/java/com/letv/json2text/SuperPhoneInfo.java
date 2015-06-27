package com.letv.json2text;


public class SuperPhoneInfo {
	private Id _id;
	private String imei;
	private String imei2;
	private String sn;
	private String meid;
	private String ui_version;
	private String software_version;
	private String hardware_version;
	private String head_code;
	private String motherboard_code;
	private String repair;
	private String product_date;
	private String shipping_date;
	private String pcb_sn;
	private String production_number;
	private String letv_part_number;
	private String plan_id;
	private String factory_part_number;
	private String sale_area;
	private String send_time;
	private String factory_delivery_time;
	private String factory;
	private String factory_delivery_id;
	private String activation_time;
	private String activation_halfhour_time;
//	private String factory_send_date;
	private String status;
	private String activation_halfhour_mobile;
	private String plan_create_username;
	private String plan_create_time;
	private String model;
	private GroupId group_id;
	private String send_username;
	private String godown_entry_id;
	private String description;
	private String external_model;
	
	
	public String getExternal_model() {
		return external_model;
	}
	public void setExternal_model(String external_model) {
		this.external_model = external_model;
	}
	public  static class Id{
		private String $oid;

		public String get$oid() {
			return $oid;
		}
		public void set$oid(String $oid) {
			this.$oid = $oid;
		}
	}
	
	
	public static class GroupId{
		private String $oid;

		public String get$oid() {
			return $oid;
		}
		public void set$oid(String $oid) {
			this.$oid = $oid;
		}
		
	}
	
	
	public Id get_id() {
		return _id;
	}
	public void set_id(Id _id) {
		this._id = _id;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getImei2() {
		return imei2;
	}
	public void setImei2(String imei2) {
		this.imei2 = imei2;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getMeid() {
		return meid;
	}
	public void setMeid(String meid) {
		this.meid = meid;
	}
	public String getUi_version() {
		return ui_version;
	}
	public void setUi_version(String ui_version) {
		this.ui_version = ui_version;
	}
	public String getSoftware_version() {
		return software_version;
	}
	public void setSoftware_version(String software_version) {
		this.software_version = software_version;
	}
	public String getHardware_version() {
		return hardware_version;
	}
	public void setHardware_version(String hardware_version) {
		this.hardware_version = hardware_version;
	}
	public String getHead_code() {
		return head_code;
	}
	public void setHead_code(String head_code) {
		this.head_code = head_code;
	}
	public String getMotherboard_code() {
		return motherboard_code;
	}
	public void setMotherboard_code(String motherboard_code) {
		this.motherboard_code = motherboard_code;
	}
	public String getRepair() {
		return repair;
	}
	public void setRepair(String repair) {
		this.repair = repair;
	}
	public String getProduct_date() {
		return product_date;
	}
	public void setProduct_date(String product_date) {
		this.product_date = product_date;
	}
	public String getShipping_date() {
		return shipping_date;
	}
	public void setShipping_date(String shipping_date) {
		this.shipping_date = shipping_date;
	}
	public String getPcb_sn() {
		return pcb_sn;
	}
	public void setPcb_sn(String pcb_sn) {
		this.pcb_sn = pcb_sn;
	}
	public String getProduction_number() {
		return production_number;
	}
	public void setProduction_number(String production_number) {
		this.production_number = production_number;
	}
	public String getLetv_part_number() {
		return letv_part_number;
	}
	public void setLetv_part_number(String letv_part_number) {
		this.letv_part_number = letv_part_number;
	}
	public String getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}
	public String getFactory_part_number() {
		return factory_part_number;
	}
	public void setFactory_part_number(String factory_part_number) {
		this.factory_part_number = factory_part_number;
	}
	public String getSale_area() {
		return sale_area;
	}
	public void setSale_area(String sale_area) {
		this.sale_area = sale_area;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public String getFactory_delivery_time() {
		return factory_delivery_time;
	}
	public void setFactory_delivery_time(String factory_delivery_time) {
		this.factory_delivery_time = factory_delivery_time;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getFactory_delivery_id() {
		return factory_delivery_id;
	}
	public void setFactory_delivery_id(String factory_delivery_id) {
		this.factory_delivery_id = factory_delivery_id;
	}
	public String getActivation_time() {
		return activation_time;
	}
	public void setActivation_time(String activation_time) {
		this.activation_time = activation_time;
	}
	public String getActivation_halfhour_time() {
		return activation_halfhour_time;
	}
	public void setActivation_halfhour_time(String activation_halfhour_time) {
		this.activation_halfhour_time = activation_halfhour_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getActivation_halfhour_mobile() {
		return activation_halfhour_mobile;
	}
	public void setActivation_halfhour_mobile(String activation_halfhour_mobile) {
		this.activation_halfhour_mobile = activation_halfhour_mobile;
	}
	public String getPlan_create_username() {
		return plan_create_username;
	}
	public void setPlan_create_username(String plan_create_username) {
		this.plan_create_username = plan_create_username;
	}
	public String getPlan_create_time() {
		return plan_create_time;
	}
	public void setPlan_create_time(String plan_create_time) {
		this.plan_create_time = plan_create_time;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSend_username() {
		return send_username;
	}
	public void setSend_username(String send_username) {
		this.send_username = send_username;
	}
	public String getGodown_entry_id() {
		return godown_entry_id;
	}
	public void setGodown_entry_id(String godown_entry_id) {
		this.godown_entry_id = godown_entry_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public GroupId getGroup_id() {
		return group_id;
	}
	public void setGroup_id(GroupId group_id) {
		this.group_id = group_id;
	}
	@Override
	public String toString() {
		return "SuperPhoneInfo [_id=" + _id + ", imei=" + imei + ", imei2="
				+ imei2 + ", sn=" + sn + ", meid=" + meid + ", ui_version="
				+ ui_version + ", software_version=" + software_version
				+ ", hardware_version=" + hardware_version + ", head_code="
				+ head_code + ", motherboard_code=" + motherboard_code
				+ ", repair=" + repair + ", product_date=" + product_date
				+ ", shipping_date=" + shipping_date + ", pcb_sn=" + pcb_sn
				+ ", production_number=" + production_number
				+ ", letv_part_number=" + letv_part_number + ", plan_id="
				+ plan_id + ", factory_part_number=" + factory_part_number
				+ ", sale_area=" + sale_area + ", send_time=" + send_time
				+ ", factory_delivery_time=" + factory_delivery_time
				+ ", factory=" + factory + ", factory_delivery_id="
				+ factory_delivery_id + ", activation_time=" + activation_time
				+ ", activation_halfhour_time=" + activation_halfhour_time
				+ ", status=" + status + ", activation_halfhour_mobile="
				+ activation_halfhour_mobile + ", plan_create_username="
				+ plan_create_username + ", plan_create_time="
				+ plan_create_time + ", model=" + model + ", group_id="
				+ group_id + ", send_username=" + send_username
				+ ", godown_entry_id=" + godown_entry_id + ", description="
				+ description + ", external_model=" + external_model + "]";
	}
	
	
	
	
}
