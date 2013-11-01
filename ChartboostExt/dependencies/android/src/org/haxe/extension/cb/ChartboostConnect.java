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
import org.haxe.extension.cb.util.com.chartboost.sdk.*;
import org.haxe.extension.Extension;
import org.haxe.nme.HaxeObject;


public class ChartboostConnect extends Extension 
{
	private static String appID = "";
	private static String appSignature = "";
	
	private static Chartboost cb;

	public static void initialize (String publicKey, HaxeObject callback)
	{

	}
	
	@override public void onCreate (Bundle savedInstanceState)
	{
		ChartboostConnect.cb = Chartboost.sharedChartboost();
		ChartboostConnect.cb.onCreate(Extension.mainActivity, ChartboostConnect.appID, ChartboostConnect.appSignature, null);
	}
	
	
	@Override public boolean onActivityResult (int requestCode, int resultCode, Intent data)
	{
		return super.onActivityResult (requestCode, resultCode, data);
	}
	
	
	@Override public void onDestroy () 
	{
		
	}
	
	@Override
	protected void onStart()
	{
		ChartboostConnect.cb.onStart(Extension.mainActivity);
	
		// Notify the beginning of a user session. Must not be dependent on user actions or any prior network requests.
		ChartboostConnect.cb.startSession();
	
		// Show an interstitial
		ChartboostConnect.cb.showInterstitial(); 
	}   
	
	@Override
	protected void onStop() 
	{
		this.cb.onStop(this);
	}
	
	@Override
	protected void onDestroy() 
	{
		this.cb.onDestroy(this);
	}
	
	@Override
	public void onBackPressed()
	{
		// If an interstitial is on screen, close it. Otherwise continue as normal.
		if (this.cb.onBackPressed())
		{
			return;
		}
	}
	
	

	
	
	
	
	
}