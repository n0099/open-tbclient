package com.qq.e.comm.plugin.ab.e;

import com.tencent.smtt.sdk.WebView;
/* loaded from: classes3.dex */
class g extends com.qq.e.comm.plugin.ab.f.h {

    /* renamed from: a  reason: collision with root package name */
    private f f11772a;

    public void a(f fVar) {
        this.f11772a = fVar;
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.f11772a != null) {
            this.f11772a.b(str);
        }
    }
}
