package com.example.soundllypreinterview;

import java.util.ArrayList;

import com.soundlly.sdk.Soundlly;
import com.soundlly.sdk.net.model.AttributesModel;
import com.soundlly.sdk.net.model.ContentsModel;
import com.soundlly.sdk.service.SoundllyService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SoundllyBroadcastReceiver extends BroadcastReceiver {

	public String url = "";
	public String comment = "";
	public String code = "";
	private Context mContext;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		mContext = context;
		if ((context.getPackageName() + SoundllyService.ACTION_RESULT).equals(intent.getAction())) {
			handleSoundllyResult(intent);
		}
	}

	private void handleSoundllyResult(Intent intent) {
		Log.i("[soundllyTest]", "CODE : " + intent.getExtras().getInt(Soundlly.EXTRA_STATUS_CODE));
		switch (intent.getExtras().getInt(Soundlly.EXTRA_STATUS_CODE)) {
			case Soundlly.CODE_OK:
				doLoadContents(intent);
				break;
			case Soundlly.CODE_NO_CONTENTS:
				//handling code for result
				break;
			case Soundlly.CODE_SERVER_ERROR:
				//handling code for result
				break;
			case Soundlly.CODE_TIME_OUT:
				//handling code for result
				break;
			case Soundlly.CODE_UNAUTHORIZED:
				//handling code for result
				break;
			case Soundlly.CODE_UNKNOWN_ERROR:
				//handling code for result
				break;
			case Soundlly.CODE_NO_WATERMARK:
				//handling code for result
				break;
			case Soundlly.CODE_MIC_ERROR:
				//handling code for result
				break;
			default:
				break;
				
		}
	}

	private void doLoadContents(Intent intent) {
		// TODO Auto-generated method stub
		ContentsModel contents = intent.getParcelableExtra(Soundlly.EXTRA_CONTENTS);
		ArrayList<AttributesModel> attributes = contents.getAttributes();
		
		if (attributes != null) {
			for (AttributesModel model : attributes) {
				if (model.getType().equals("string")) {
					if (model.getKey().equals("url")) {
						url = model.getValue();
					} else {
						comment = model.getValue();
					}
				} else if (model.getType().equals("integer")) {
					if (model.getKey().equals("code")) {
						code = model.getValue();
					}
				}
			}
		}
		
		Intent i = new Intent(mContext, SoundllyResultActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.putExtra("code", code);
		i.putExtra("comment", comment);
		i.putExtra("url", url);
		
		mContext.startActivity(i);
	}
	
}
