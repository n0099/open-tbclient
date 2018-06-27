package com.sina.weibo.sdk.web.client;

import android.annotation.TargetApi;
import android.app.Activity;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sina.weibo.sdk.web.WebViewRequestCallback;
import com.sina.weibo.sdk.web.param.BaseWebViewRequestParam;
/* loaded from: classes2.dex */
public abstract class BaseWebViewClient extends WebViewClient {
    protected BaseWebViewRequestParam param;
    protected WebViewRequestCallback requestCallback;

    public BaseWebViewClient(WebViewRequestCallback webViewRequestCallback, BaseWebViewRequestParam baseWebViewRequestParam) {
        this.requestCallback = webViewRequestCallback;
        this.param = baseWebViewRequestParam;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.requestCallback != null) {
            this.requestCallback.shouldOverrideUrlLoadingCallBack(webView, webResourceRequest.getUrl().toString());
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.requestCallback != null) {
            this.requestCallback.shouldOverrideUrlLoadingCallBack(webView, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.requestCallback != null) {
            this.requestCallback.onReceivedSslErrorCallBack(webView, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public void closeWeb() {
    }

    public void errorBack(Activity activity, String str) {
    }

    public boolean onBackKeyDown() {
        return false;
    }
}
