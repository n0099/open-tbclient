package com.win.opensdk;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: classes7.dex */
public class Q extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public String f39770a;

    /* renamed from: b  reason: collision with root package name */
    public String f39771b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ S f39772c;

    public Q(S s) {
        this.f39772c = s;
    }

    public final boolean a(String str) {
        S s = this.f39772c;
        if (s.f39788d) {
            s.f39788d = false;
            S s2 = this.f39772c;
            A2 a2 = s2.f39786b;
            if (a2 != null) {
                return a2.a(str, s2.f39789e);
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (TextUtils.isEmpty(this.f39771b)) {
            this.f39771b = str;
            C2 c2 = this.f39772c.f39785a;
            if (c2 != null) {
                c2.onLoaded();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f39770a = webView.getUrl();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if ((TextUtils.equals(webView.getUrl(), "http://abcd/") || TextUtils.equals(webView.getUrl(), this.f39770a)) && Build.VERSION.SDK_INT >= 23) {
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
