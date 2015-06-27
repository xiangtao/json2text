package com.letv.json2text.translator;

public enum TranslatorName { 
	   MobileTranslator("mobile"),MobileGroupsTranslator("mobile_groups"),MobilePartnumberTranslator("mobile_partnumber"),MobileTranslatorForCSV("mobilecsv"); 
	   
	   private final String name; 
	   private TranslatorName(String name) { 
	      this.name = name; 
	        }
			public String getName() {
				return name;
			} 
	      
	}