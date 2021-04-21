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
    public String f40155a;

    /* renamed from: b  reason: collision with root package name */
    public String f40156b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ S f40157c;

    public Q(S s) {
        this.f40157c = s;
    }

    public final boolean a(String str) {
        S s = this.f40157c;
        if (s.f40173d) {
            s.f40173d = false;
            S s2 = this.f40157c;
            A2 a2 = s2.f40171b;
            if (a2 != null) {
                return a2.a(str, s2.f40174e);
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (TextUtils.isEmpty(this.f40156b)) {
            this.f40156b = str;
            C2 c2 = this.f40157c.f40170a;
            if (c2 != null) {
                c2.onLoaded();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f40155a = webView.getUrl();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if ((TextUtils.equals(webView.getUrl(), "http://abcd/") || TextUtils.equals(webView.getUrl(), this.f40155a)) && Build.VERSION.SDK_INT >= 23) {
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
