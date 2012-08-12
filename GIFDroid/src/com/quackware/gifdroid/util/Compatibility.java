package com.quackware.gifdroid.util;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Compatibility {
	
	public static boolean SUPPORT_MEDIAMETADATARETRIEVER = false;
	public static boolean SUPPORT_FFMPEG = true;
	
	public static void checkCompatibility(Context con)
	{
		int version = Integer.valueOf(android.os.Build.VERSION.SDK);
		if(version >= 10)
    	{
			SUPPORT_MEDIAMETADATARETRIEVER = true;
    	}
		else
		{
			SUPPORT_MEDIAMETADATARETRIEVER = false;
		}
		
		if(version < 14)
		{
			SUPPORT_FFMPEG = true;
		}
		else
		{
			SUPPORT_FFMPEG = false;
		}
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(con);
		SharedPreferences.Editor editor = prefs.edit();
		if(SUPPORT_FFMPEG == false && SUPPORT_MEDIAMETADATARETRIEVER)
		{
			editor.putString("listPreferenceDecoder", "0");
			editor.commit();
		}
		
	}

}
