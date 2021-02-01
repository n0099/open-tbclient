package com.qq.e.comm.plugin.ab.e;

import android.webkit.WebView;
/* loaded from: classes15.dex */
class b extends com.qq.e.comm.plugin.ab.f.b {

    /* renamed from: a  reason: collision with root package name */
    private f f11769a;

    public void a(f fVar) {
        this.f11769a = fVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.f11769a != null) {
            this.f11769a.b(str);
        }
    }
}
