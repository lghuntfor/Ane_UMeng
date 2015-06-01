package
{
	
	import com.xkw.ane.umeng.UMeng;
	
	import flash.display.Sprite;
	import flash.display.StageAlign;
	import flash.display.StageScaleMode;
	import flash.text.TextField;
	import flash.text.TextFormat;
	
	public class UMengSA extends Sprite
	{
		private var tf:TextField;
		public function UMengSA()
		{
			super();
			
			// 支持 autoOrient
			stage.align = StageAlign.TOP_LEFT;
			stage.scaleMode = StageScaleMode.NO_SCALE;
			
			
			var init:String  = UMeng.init();
			var onResume:String = UMeng.onResume();
			var onPause:String = UMeng.onPause();
			var count:String = UMeng.count("zhanfa");
			var purchase:String = UMeng.purchase("yinianji", "50");
			
			var shareBoard:String = UMeng.shareBoard();
			tf = new TextField();
			
			tf.text = "umeng:"
				+init+",\n"
				+onResume+",\n"
				+count+",\n"
				+purchase+",\n"
				+shareBoard+",\n"
				+onPause
				;
			tf.width = 1000;
			tf.height = 1500;
			var formatter:TextFormat = new TextFormat();
			formatter.size = 35;
			tf.setTextFormat(formatter);
			addChild(tf);
		}
	}
}