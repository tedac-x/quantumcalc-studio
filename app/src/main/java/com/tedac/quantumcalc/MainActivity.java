package com.tedac.quantumcalc;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle Bundle) {
        super.onCreate(Bundle);
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient()); // Keeps links opening inside the app

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enables calculator functionality
        webSettings.setDomStorageEnabled(true); // Enables local storage for logs

        // Replace this link with your live GitHub Pages URL deployment
        myWebView.loadUrl("file:///android_asset/index.html");
    }

    // Handles the device hardware back button inside the web app
    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}