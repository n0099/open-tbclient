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
    public String f40060a;

    /* renamed from: b  reason: collision with root package name */
    public String f40061b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ S f40062c;

    public Q(S s) {
        this.f40062c = s;
    }

    public final boolean a(String str) {
        S s = this.f40062c;
        if (s.f40078d) {
            s.f40078d = false;
            S s2 = this.f40062c;
            A2 a2 = s2.f40076b;
            if (a2 != null) {
                return a2.a(str, s2.f40079e);
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (TextUtils.isEmpty(this.f40061b)) {
            this.f40061b = str;
            C2 c2 = this.f40062c.f40075a;
            if (c2 != null) {
                c2.onLoaded();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f40060a = webView.getUrl();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if ((TextUtils.equals(webView.getUrl(), "http://abcd/") || TextUtils.equals(webView.getUrl(), this.f40060a)) && Build.VERSION.SDK_INT >= 23) {
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
