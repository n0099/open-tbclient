package com.qq.e.comm.plugin.ab.e;

import com.tencent.smtt.sdk.WebView;
/* loaded from: classes15.dex */
class g extends com.qq.e.comm.plugin.ab.f.h {

    /* renamed from: a  reason: collision with root package name */
    private f f11774a;

    public void a(f fVar) {
        this.f11774a = fVar;
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.f11774a != null) {
            this.f11774a.b(str);
        }
    }
}
