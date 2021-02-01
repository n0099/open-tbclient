package com.qq.e.comm.plugin.ab.f;

import android.annotation.TargetApi;
import android.util.Pair;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.qq.e.comm.plugin.util.az;
import java.io.InputStream;
/* loaded from: classes15.dex */
public class d extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private boolean f11793a;

    /* renamed from: b  reason: collision with root package name */
    private g f11794b = new g();

    public void a() {
        this.f11793a = true;
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Pair<? extends InputStream, az.a> a2 = this.f11794b.a(this.f11793a, webResourceRequest.getUrl());
        if (a2 == null) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        InputStream inputStream = (InputStream) a2.first;
        return inputStream == null ? super.shouldInterceptRequest(webView, webResourceRequest) : new WebResourceResponse(((az.a) a2.second).a(), "UTF-8", inputStream);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.f11794b.a(str);
    }
}
