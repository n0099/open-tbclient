package com.qq.e.comm.plugin.ab.e;

import android.webkit.WebView;
/* loaded from: classes3.dex */
class b extends com.qq.e.comm.plugin.ab.f.b {

    /* renamed from: a  reason: collision with root package name */
    private f f11767a;

    public void a(f fVar) {
        this.f11767a = fVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.f11767a != null) {
            this.f11767a.b(str);
        }
    }
}
