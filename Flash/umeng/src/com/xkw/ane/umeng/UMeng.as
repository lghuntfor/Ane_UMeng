package com.xkw.ane.umeng
{
	import flash.external.ExtensionContext;
	
	/**
	 * 友盟sdk中api的封装
	 */
	
	public class UMeng
	{
		private static const EXTENSION_ID:String = "com.xkw.ane.umeng";
		public static const FAILED_RESULT:String = "ExtensionContext创建失败";
		private static const KEY:String = "analysis";
		
		private static const extContext:ExtensionContext = ExtensionContext.createExtensionContext(EXTENSION_ID, "");
		
		
		/**
		 * 对友盟的初始化,若在配置文件中已经配置appKey以及channelId,则无需再调用此方法
		 * @param appKey	友盟后台中统计app应用所生成的唯一key
		 * @param channelId		app所推广渠道的名称
		 * @return 
		 */		
		public static function config(appKey:String, channelId:String):String {
			if(extContext){
				return extContext.call(KEY, "config", appKey, channelId) as String;
			}
			return FAILED_RESULT;			
		}
		
		
		/**
		 * 初始化方法,需在程序入口处调用
		 * 1.用于定义发送策略,默认设置在线更新,可再通过updateOnlineConfig()方法进行更改
		 * 2.用于设置发送日志加密,可再通过 enableEncrypt()方法更改
		 */		
		public static function init():String {
			//定义发送策略,设置在线更新
			var updateOnlineConfig:String = updateOnlineConfig(true);
			//设置日志信息的加密发送
			var enableEncrypt:String = enableEncrypt(true);
			return updateOnlineConfig+","+enableEncrypt;
		}
		
		
		/**
		 * 定义发送策略,设置是否在线更新
		 * 需在程序入口处调用 
		 * @param enabled 设置是否在线更新,true为在线更新,
		 * @return 
		 * 
		 */		
		public static function updateOnlineConfig(enabled:Boolean):String {
			if(extContext){
				return extContext.call(KEY, "updateOnlineConfig", enabled.toString()) as String;
			}
			return FAILED_RESULT;
		}
		
		
		/**
		 * 设置是否日志加密,加密模式可以有效防止网络攻击，提高数据安全性
		 * @param enabled	传入布尔值true即设置日志加密
		 * @return 
		 * 
		 */		
		public static function enableEncrypt(enabled:Boolean):String {
			if(extContext){
				return extContext.call(KEY, "enableEncrypt", enabled.toString()) as String;
			}
			return FAILED_RESULT;
		}
		
		
		/**
		 * 当使用者启动程序和重新回到使用界面时调用此方法
		 * @return 
		 */		
		public static function onResume():String {
			if(extContext){
				return extContext.call(KEY, "onResume") as String;
			}
			return FAILED_RESULT;
		}
		
		
		/**
		 * 当离开软件使用界面和退出程序时调用此方法
		 */
		public static function onPause():String {
			if(extContext){
				return extContext.call(KEY, "onPause") as String;
			}
			return FAILED_RESULT;
		}
		
		
		/**
		 * 社交分享统计 : 如在分享至微博后调用此方法 
		 * @param socialType 社交分享的类型, 必须使用Media类中所定义的类型
		 * @param userId 用户的Id
		 * @return 
		 * 
		 */		
		public static function socialStatistics(socialType:String, userId:String):String {
			if(extContext){
				return extContext.call(KEY, "socialStatistics", socialType, userId) as String;
			}
			return FAILED_RESULT;
		}
		
		
		/**
		 * 计数事件
		 * 统计事件发生次数
		 * @param eventId	eventId 事件id, 字母或数字的字符串,不能使用汉字
		 * @return 
		 * 
		 */		
		public static function count(eventId:String):String {
			if(extContext){
				return extContext.call(KEY, "count", eventId) as String;
			}
			return FAILED_RESULT;
		}
		
		
		/**
		 * 计算事件:
	 	 * 书籍购买行为及购买金额的事件统计
		 * @param bookName 书籍名称,如值以入yinianji
		 * @param amount 购买的金额传入金额的字符串开形式即可
		 * @return 
		 */		
		public static function purchase(bookName:String, amount:String):String {
			if(extContext){
				return extContext.call(KEY, "purchase", bookName, amount) as String;
			}
			return FAILED_RESULT;
		}
		
		
		public static function shareBoard():String {
			if(extContext){
				return extContext.call(KEY,"shareBoard") as String;
			}
			return FAILED_RESULT;
		}
		
	}
}