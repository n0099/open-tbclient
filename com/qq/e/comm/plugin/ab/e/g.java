package com.qq.e.comm.plugin.ab.e;

import com.tencent.smtt.sdk.WebView;
/* loaded from: classes4.dex */
class g extends com.qq.e.comm.plugin.ab.f.h {

    /* renamed from: a  reason: collision with root package name */
    private f f12072a;

    public void a(f fVar) {
        this.f12072a = fVar;
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.f12072a != null) {
            this.f12072a.b(str);
        }
    }
}
