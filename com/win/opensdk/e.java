package com.win.opensdk;

import android.webkit.JsResult;
/* loaded from: classes14.dex */
public class e implements o {
    public final /* synthetic */ C0 qkf;

    public e(C0 c0) {
        this.qkf = c0;
    }

    public void a(C0 c0, boolean z) {
    }

    public boolean a(String str) {
        g gVar;
        ag agVar = this.qkf.qkt;
        if (agVar != null && (gVar = ((be) agVar).qla) != null) {
            return gVar.a(str, "");
        }
        return false;
    }

    public boolean a(boolean z) {
        return false;
    }

    public boolean b(String str, JsResult jsResult) {
        return false;
    }

    public void a() {
        ag agVar = this.qkf.qkt;
        if (agVar != null) {
            ((be) agVar).c();
        }
    }
}
