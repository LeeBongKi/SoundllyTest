package com.example.soundllypreinterview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SoundllyResultActivity extends ActionBarActivity {
	
	private WebView mWebview;
	public String url = "";
	public String comment = "";
	public String code = "";
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_soundlly_resullt);
	    
	    Intent intent = getIntent();
	    code = intent.getStringExtra("code");
	    comment = intent.getStringExtra("comment");
	    url = intent.getStringExtra("url");
	    
	    Log.i("[soundllyTest]", "code :" + code);
	    Log.i("[soundllyTest]", "comment :" + comment);
	    Log.i("[soundllyTest]", "url :" + url);
	    
	    mWebview = (WebView)findViewById(R.id.result_web_view);
	    mWebview.getSettings().setJavaScriptEnabled(true);
	    mWebview.loadUrl(url);
	    mWebview.setWebViewClient(new WebViewClientClass());
	}

	private class WebViewClientClass extends WebViewClient { 
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { 
            view.loadUrl(url); 
            return true; 
        } 
    }
}
