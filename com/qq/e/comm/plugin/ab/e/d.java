package com.qq.e.comm.plugin.ab.e;

import android.graphics.Bitmap;
import android.webkit.WebView;
/* loaded from: classes4.dex */
class d extends com.qq.e.comm.plugin.ab.f.d {

    /* renamed from: a  reason: collision with root package name */
    private f f12070a;

    public void a(f fVar) {
        this.f12070a = fVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.f12070a != null) {
            this.f12070a.a(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.f12070a != null) {
            this.f12070a.a(str, bitmap);
        }
    }
}
