package extension.haxeChartboost;


import flash.events.EventDispatcher;
import flash.events.Event;
import flash.net.SharedObjectFlushStatus;
import flash.net.SharedObject;
import flash.Lib;

#if android
import openfl.utils.JNI;
#end


@:allow(extension.haxeChartboost) class HaxeChartboost 
{
	static var ShowAdFunc;
	public static function OpenIntersetial():Void
	{
		#if android
		trace("ATTEMPTING TO CREATE FUNCTION FOR CHARTBOOST");
		if (ShowAdFunc == null)
		{
			ShowAdFunc = JNI.createStaticMethod("org/haxe/extension/cb/ChartboostConnect", "ShowAd", "()V");
		}
		
		Lib.postUICallback(function(){
		ShowAdFunc(); } );
		#end
		
		#if ios
		trace("ATTEMPTING TO OPEN AD FOR CHARTBOOST");
		
		Lib.postUICallback(function(){
		cb_show_interstitial(); } );
		#end
	}
	
	#if ios
	public static function init(appID:String, appSignature:String)
	{
		cb_init(appID, appSignature);
		isInit = true;
	}

	static var cb_init               = Lib.load("ruechartboost","cb_setup",2);
	static var cb_show_interstitial  = Lib.load("ruechartboost","cb_show_interstitial", 0);
	
	#end
	
}
