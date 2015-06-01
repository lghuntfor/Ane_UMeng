package com.xkw.ane.umeng.share;

import android.app.Activity;

import com.adobe.fre.FREContext;

public class UMengShare {

	private Activity activity = null;
	
	public UMengShare(FREContext pContext) {
		activity = pContext.getActivity();
	}


}
