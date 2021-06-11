package com.win.opensdk;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: classes7.dex */
public class J extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public String f40523a;

    /* renamed from: b  reason: collision with root package name */
    public String f40524b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ K f40525c;

    public J(K k) {
        this.f40525c = k;
    }

    public final boolean a(String str) {
        K k = this.f40525c;
        if (k.f40531d) {
            k.f40531d = false;
            K k2 = this.f40525c;
            V1 v1 = k2.f40529b;
            if (v1 != null) {
                return v1.a(str, k2.f40532e);
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (TextUtils.isEmpty(this.f40524b)) {
            this.f40524b = str;
            X1 x1 = this.f40525c.f40528a;
            if (x1 != null) {
                x1.onLoaded();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f40523a = webView.getUrl();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if ((TextUtils.equals(webView.getUrl(), "http://abcd/") || TextUtils.equals(webView.getUrl(), this.f40523a)) && Build.VERSION.SDK_INT >= 23) {
            webResourceError.getDescription().toString();
            webResourceError.getErrorCode();
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT < 24 || !a(webResourceRequest.getUrl().toString())) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (Build.VERSION.SDK_INT >= 24 || !a(str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }
}
