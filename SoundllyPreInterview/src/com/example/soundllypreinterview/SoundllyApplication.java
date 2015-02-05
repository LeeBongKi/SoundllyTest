package com.example.soundllypreinterview;

import android.app.Application;
import com.soundlly.sdk.SoundllyCore;

public class SoundllyApplication extends Application {

	public static final String API_KEY = "54c5c5b4-0a9205df-da905901-d05fifb8";
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		SoundllyCore.init(this);
	}
}
