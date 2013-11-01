package org.haxe.extension.cb;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.chartboost.sdk.*;
import org.haxe.extension.Extension;
import org.haxe.nme.HaxeObject;


public class ChartboostConnect extends Extension 
{
	private static String appID = "5273ce8c17ba472c3700000d";
	private static String appSignature = "46d89ebcdb850677c37544ed1f134d070257820b";
	
	private static Chartboost cb;
	
	@Override public void onCreate (Bundle savedInstanceState)
	{
		Log.e("ChartboostConnect", "CREATING CHARTBOOST SERVICE");
		ChartboostConnect.cb = Chartboost.sharedChartboost();
		ChartboostConnect.cb.onCreate(Extension.mainActivity, ChartboostConnect.appID, ChartboostConnect.appSignature, null);
		//ChartboostConnect.cb.startSession();
	}
	
	
	//@Override public boolean onActivityResult (int requestCode, int resultCode, Intent data)
	//{
		//return super.onActivityResult (requestCode, resultCode, data);
	//}
	
	@Override public void onStart()
	{
		Log.e("ChartboostConnect", "STARTING CHARTBOOST");
		ChartboostConnect.cb.onStart(Extension.mainActivity);
	
		// Notify the beginning of a user session. Must not be dependent on user actions or any prior network requests.
		ChartboostConnect.cb.startSession();
		
		// ChartboostConnect.cb.showInterstitial(); 
	}   
	
	@Override public void onStop() 
	{
		Log.e("ChartboostConnect", "STOPPING CHARTBOOST");
		ChartboostConnect.cb.onBackPressed();
		ChartboostConnect.cb.onStop(Extension.mainActivity);
	}
	
	@Override public void onDestroy() 
	{
		ChartboostConnect.cb.onDestroy(Extension.mainActivity);
	}
	
	public static void ShowAd()
	{
		if(ChartboostConnect.cb != null)
		{
			if(ChartboostConnect.cb.onBackPressed())
			{
				ChartboostConnect.cb.showInterstitial(); 
			}
			else
			{
				ChartboostConnect.cb.showInterstitial(); 
			}
		}
		
	}
	
	
	

	
	
	
	
	
}