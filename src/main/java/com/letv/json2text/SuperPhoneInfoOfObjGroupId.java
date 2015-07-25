package com.letv.json2text;


public class SuperPhoneInfoOfObjGroupId extends SuperPhoneInfoBase{
	private GroupId group_id;
	public static class GroupId{
		private String $oid;

		public String get$oid() {
			return $oid;
		}
		public void set$oid(String $oid) {
			this.$oid = $oid;
		}
		
	}
	public GroupId getGroup_id() {
		return group_id;
	}
	public void setGroup_id(GroupId group_id) {
		this.group_id = group_id;
	}
	@Override
	public String toString() {
		return super.toString() + " SuperPhoneInfoOfObjGroupId [group_id=" + group_id + "]";
	}
	
	
}
