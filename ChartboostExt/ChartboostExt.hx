package;

#if cpp
import cpp.Lib;
#elseif neko
import neko.Lib;
#end


class ChartboostExt {
	
	
	public static function sampleMethod (inputValue:Int):Int {
		
		return chartboostext_sample_method(inputValue);
		
	}
	
	
	private static var chartboostext_sample_method = Lib.load ("chartboostext", "chartboostext_sample_method", 1);
	
	
}