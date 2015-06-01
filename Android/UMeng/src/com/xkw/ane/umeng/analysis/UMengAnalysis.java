package com.xkw.ane.umeng.analysis;

import java.util.HashMap;

import android.annotation.SuppressLint;
import android.content.Intent;

import com.adobe.fre.FREContext;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMPlatformData.UMedia;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;

/**
 * 友盟API的封装
 * @author anonymous
 *
 */

public class UMengAnalysis {
	private FREContext ctx;
	
	public UMengAnalysis(FREContext ctx) {
		this.ctx = ctx;
	}
	
	/**
	 * 对友盟的初始化,需传入appKey(唯一)与channel
	 * @param appKey
	 * @param channelId
	 * @return
	 */
	public String config(String appKey, String channelId) {
		AnalyticsConfig.setAppkey(appKey);
		AnalyticsConfig.setChannel(channelId);
		return "config";
	}
	
	/**
	 * 定义发送策略,在程序入口处调用此方法
	 * @return
	 */
	@SuppressLint("DefaultLocale")
	public String updateOnlineConfig(String enableStr) {
		if(!"true".equals(enableStr.toLowerCase()) && !"false".equals(enableStr.toLowerCase())){
			enableStr = "false";
		}
		Boolean enable = Boolean.valueOf(enableStr);
		if(enable) {
			MobclickAgent.updateOnlineConfig(ctx.getActivity().getBaseContext());
		}
		return "updateOnlineConfig";
	}
	
	/**
	 * 当使用者重新使用此界面时调用此方法
	 * @return
	 */
	public String onResume() {
		MobclickAgent.onResume(ctx.getActivity().getBaseContext());
		return "onResume";
	}
	
	/**
	 * 当使用者加离开用户界面时调用此方法
	 * @return
	 */
	public String onPause() {
		MobclickAgent.onPause(ctx.getActivity().getBaseContext());
		return "onPause";
	}
	
	/**
	 * 设置日志加密,在程序入口处调用此方法. 加密模式可以有效防止网络攻击，提高数据安全性。
	 * @param enable, true/false
	 * @return
	 */
	@SuppressLint("DefaultLocale")
	public String enableEncrypt(String enableStr) {
		if(!"true".equals(enableStr.toLowerCase()) && !"false".equals(enableStr.toLowerCase())){
			enableStr = "false";
		}
		Boolean enable = Boolean.valueOf(enableStr);
		AnalyticsConfig.enableEncrypt(enable);
		return "enableEncrypt";
	}
	
	/**
	 * 社交统计,比如分享到新浪微博后调用此方法
	 * @param socialType 社交分享的类型, 如微博,微信朋友圈
	 * @param userId
	 * @return
	 */
	public String socialStatistics(String socialType, String userId) {
		
		UMedia media = null;
		
		if("DOUBAN".equals(UMedia.DOUBAN.toString())) {
			media = UMedia.DOUBAN;	//豆辨分享
		} else if("RENREN".equals(UMedia.RENREN.toString())) {
			media = UMedia.RENREN;	//人人网的分享
		} else if("SINA_WEIBO".equals(UMedia.SINA_WEIBO.toString())) {
			media = UMedia.SINA_WEIBO;	//新浪微博的分享
		} else if("TENCENT_QQ".equals(UMedia.TENCENT_QQ.toString())) {
			media = UMedia.TENCENT_QQ;	//腾讯QQ的分享
		} else if("TENCENT_QZONE".equals(UMedia.TENCENT_QZONE.toString())) {
			media = UMedia.TENCENT_QZONE;	//腾讯QQ空间的分享
		} else if("TENCENT_WEIBO".equals(UMedia.TENCENT_WEIBO.toString())) {
			media = UMedia.TENCENT_WEIBO;	//腾讯微博的分享
		} else if("WEIXIN_CIRCLE".equals(UMedia.WEIXIN_CIRCLE.toString())) {
			media = UMedia.WEIXIN_CIRCLE;	//微信朋友圈的分享
		} else if("".equals(UMedia.WEIXIN_FRIENDS.toString())) {
			media = UMedia.WEIXIN_FRIENDS;	//微信好友的分享
		} else {
			return "param is error";
		}
		
		UMPlatformData platform = new UMPlatformData(media , userId);
		MobclickAgent.onSocialEvent(ctx.getActivity().getBaseContext(), platform);
		return "socialStatistics";
	}
	
	
	/**
	 * 计数事件
	 * 统计事件发生次数
	 * @param eventId 事件id, 字母或数字的字符串,不能使用汉字
	 * @return
	 */
	public String count(String eventId) {
		MobclickAgent.onEvent(ctx.getActivity().getBaseContext(), eventId);
		return "count";
	}
	
	
	/**
	 * 计算事件:
	 * 购买行为的事件统计
	 * @param bookName
	 * @param amount
	 * @return
	 */
	public String purchase(String type, String amount) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("type", type);
		map.put("amount", amount); 
		MobclickAgent.onEvent(ctx.getActivity().getBaseContext(), "purchase", map);
		
		return "purchase";
	}
	
	
	public String shareBoard(){
		// 首先在您的Activity中添加如下成员变量
		final UMSocialService mController = UMServiceFactory.getUMSocialService("com.umeng.share");
		// 设置分享内容
		mController.setShareContent("友盟社会化组件（SDK）让移动应用快速整合社交分享功能，http://www.umeng.com/social");
		mController.getConfig().removePlatform(SHARE_MEDIA.RENREN, SHARE_MEDIA.DOUBAN);
		mController.openShare(ctx.getActivity(), false);
		
		ctx.getActivity().startActivity(new Intent("com.umeng.socialize.view.ShareActivity"));
		
		return "shareBoard";
	}
	
	
	
	
}
