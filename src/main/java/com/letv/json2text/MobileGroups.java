package com.letv.json2text;

public class MobileGroups {
	
	private Id _id;
	private String model;
	private String title;
	private String is_default;
	private String description;
	private String status;
	
	public  static class Id{
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
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getIs_default() {
		return is_default;
	}
	public void setIs_default(String is_default) {
		this.is_default = is_default;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "MobileGroups [_id=" + _id + ", model=" + model + ", title="
				+ title + ", is_default=" + is_default + ", description="
				+ description + ", status=" + status + "]";
	}
	
	

}
