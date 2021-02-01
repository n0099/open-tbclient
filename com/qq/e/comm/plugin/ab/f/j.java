package com.qq.e.comm.plugin.ab.f;

import android.annotation.TargetApi;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.qq.e.comm.plugin.util.az;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.InputStream;
/* loaded from: classes15.dex */
public class j extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private boolean f11814a;

    /* renamed from: b  reason: collision with root package name */
    private g f11815b = new g();

    public void a() {
        this.f11814a = true;
    }

    @Nullable
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Pair<? extends InputStream, az.a> a2 = this.f11815b.a(this.f11814a, webResourceRequest.getUrl());
        if (a2 == null) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        InputStream inputStream = (InputStream) a2.first;
        return inputStream == null ? super.shouldInterceptRequest(webView, webResourceRequest) : new WebResourceResponse(((az.a) a2.second).a(), "UTF-8", inputStream);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.f11815b.a(str);
    }
}
