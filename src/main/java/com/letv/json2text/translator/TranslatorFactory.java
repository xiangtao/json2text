package com.letv.json2text.translator;

public class TranslatorFactory {
	
	public static Translator getTranslator(String translator){
		Translator trans = null;
    if(TranslatorName.MobileTranslator.getName().equals(translator)){
    	 trans = new MobileTranslator();
		 }else if(TranslatorName.MobileGroupsTranslator.getName().equals(translator)){
			 trans = new MobileGroupsTranslator();
		  }else if(TranslatorName.MobilePartnumberTranslator.getName().equals(translator)){
			  trans = new MobilePartnumberTranslator();
		  }else if(TranslatorName.MobileTranslatorForCSV.getName().equals(translator)){
			  trans = new MobileTranslatorForCSV();
		  }
    return trans;
	}

}
