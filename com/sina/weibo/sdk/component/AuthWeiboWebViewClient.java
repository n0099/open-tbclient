package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.sina.weibo.sdk.utils.Utility;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class AuthWeiboWebViewClient extends WeiboWebViewClient {
    private boolean isCallBacked = false;
    private Activity mAct;
    private AuthRequestParam mAuthRequestParam;
    private WeiboAuthListener mListener;

    public AuthWeiboWebViewClient(Activity activity, AuthRequestParam authRequestParam) {
        this.mAct = activity;
        this.mAuthRequestParam = authRequestParam;
        this.mListener = this.mAuthRequestParam.getAuthListener();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.mCallBack != null) {
            this.mCallBack.onPageStartedCallBack(webView, str, bitmap);
        }
        if (str.startsWith(this.mAuthRequestParam.getAuthInfo().getRedirectUrl()) && !this.isCallBacked) {
            this.isCallBacked = true;
            handleRedirectUrl(str);
            webView.stopLoading();
            WeiboSdkBrowser.closeBrowser(this.mAct, this.mAuthRequestParam.getAuthListenerKey(), null);
            return;
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.mCallBack != null) {
            this.mCallBack.shouldOverrideUrlLoadingCallBack(webView, str);
        }
        if (str.startsWith("sms:")) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("address", str.replace("sms:", ""));
            intent.setType("vnd.android-dir/mms-sms");
            this.mAct.startActivity(intent);
            return true;
        } else if (str.startsWith(WeiboSdkBrowser.BROWSER_CLOSE_SCHEME)) {
            if (this.mListener != null) {
                this.mListener.onCancel();
            }
            WeiboSdkBrowser.closeBrowser(this.mAct, this.mAuthRequestParam.getAuthListenerKey(), null);
            return true;
        } else {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.mCallBack != null) {
            this.mCallBack.onPageFinishedCallBack(webView, str);
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.mCallBack != null) {
            this.mCallBack.onReceivedErrorCallBack(webView, i, str, str2);
        }
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.mCallBack != null) {
            this.mCallBack.onReceivedSslErrorCallBack(webView, sslErrorHandler, sslError);
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    private void handleRedirectUrl(String str) {
        Bundle parseUrl = Utility.parseUrl(str);
        String string = parseUrl.getString("error");
        String string2 = parseUrl.getString("error_code");
        String string3 = parseUrl.getString("error_description");
        if (string == null && string2 == null) {
            if (this.mListener != null) {
                this.mListener.onComplete(parseUrl);
            }
        } else if (this.mListener != null) {
            this.mListener.onWeiboException(new WeiboAuthException(string2, string, string3));
        }
    }
}
