package com.qq.e.comm.plugin.ab.e;

import android.webkit.WebView;
/* loaded from: classes3.dex */
class b extends com.qq.e.comm.plugin.ab.f.b {

    /* renamed from: a  reason: collision with root package name */
    private f f12066a;

    public void a(f fVar) {
        this.f12066a = fVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.f12066a != null) {
            this.f12066a.b(str);
        }
    }
}
