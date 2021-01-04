package com.qq.e.comm.plugin.ab.e;

import android.graphics.Bitmap;
import com.qq.e.comm.plugin.ab.f.j;
import com.tencent.smtt.sdk.WebView;
/* loaded from: classes3.dex */
class i extends j {

    /* renamed from: a  reason: collision with root package name */
    private f f12074a;

    public void a(f fVar) {
        this.f12074a = fVar;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.f12074a != null) {
            this.f12074a.a(str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.f12074a != null) {
            this.f12074a.a(str, bitmap);
        }
    }
}
