package com.qq.e.comm.plugin.ab.e;

import android.graphics.Bitmap;
import android.webkit.WebView;
/* loaded from: classes3.dex */
class d extends com.qq.e.comm.plugin.ab.f.d {

    /* renamed from: a  reason: collision with root package name */
    private f f12069a;

    public void a(f fVar) {
        this.f12069a = fVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.f12069a != null) {
            this.f12069a.a(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.f12069a != null) {
            this.f12069a.a(str, bitmap);
        }
    }
}
