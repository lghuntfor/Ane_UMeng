package com.xkw.ane.umeng;
import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.xkw.ane.umeng.analysis.UMengAnalysisFunction;
import com.xkw.ane.umeng.share.UMengShareFunction;

/**
 * FREContext的子类
 * @author anonymous
 */

public class UMengContext extends FREContext {

	public UMengContext() {
	}
	
	@Override
	public void dispose() {
	}
	
	@Override
	public Map<String, FREFunction> getFunctions() {
		HashMap<String, FREFunction> map = new HashMap<String, FREFunction>();  
		//友盟统计分析
        map.put("analysis", new UMengAnalysisFunction());  
        map.put("share", new UMengShareFunction());  
        return map;
	}
}

