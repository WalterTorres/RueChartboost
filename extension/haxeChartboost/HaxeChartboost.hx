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
	private static var dispatcher = new EventDispatcher ();

	public static function addEventListener (type:String, listener:Dynamic, useCapture:Bool = false, priority:Int = 0, useWeakReference:Bool = false):Void
	{
		dispatcher.addEventListener (type, listener, useCapture, priority, useWeakReference);
	}

	
	public static function dispatchEvent (event:Event):Bool
	{
		return dispatcher.dispatchEvent (event);
	}

	public static function hasEventListener (type:String):Bool 
	{
		return dispatcher.hasEventListener (type);
	}

	private static function notifyListeners (inEvent:Dynamic):Void 
	{
		#if ios
		
		var type = Std.string (Reflect.field (inEvent, "type"));
		var data = Std.string (Reflect.field (inEvent, "data"));
		
		switch (type)
		{

		}
		#end
	}

	private static function registerHandle ():Void
	{
		#if ios
		set_event_handle (notifyListeners);
		#end
	}
	

	public static function removeEventListener (type:String, listener:Dynamic, capture:Bool = false):Void
	{
		dispatcher.removeEventListener (type, listener, capture);
	}
	
	
	
	
	
	
	// Native Methods
	
	
	
	
	#if android
	
	
	
	#elseif ios
	

	#end
	
	
}


#if (android && !display)


private class CBHandler 
{
	
	public function new () 
	{

	}

}

#end