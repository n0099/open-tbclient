package com.qq.e.comm.plugin.ab.e;

import android.graphics.Bitmap;
import com.qq.e.comm.plugin.ab.f.j;
import com.tencent.smtt.sdk.WebView;
/* loaded from: classes15.dex */
class i extends j {

    /* renamed from: a  reason: collision with root package name */
    private f f11777a;

    public void a(f fVar) {
        this.f11777a = fVar;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.f11777a != null) {
            this.f11777a.a(str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.f11777a != null) {
            this.f11777a.a(str, bitmap);
        }
    }
}
