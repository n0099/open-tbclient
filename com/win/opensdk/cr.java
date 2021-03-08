package com.win.opensdk;

import java.io.UnsupportedEncodingException;
import java.util.Map;
/* loaded from: classes14.dex */
public class cr implements Runnable {
    public final /* synthetic */ cu qlC;

    public cr(cu cuVar) {
        this.qlC = cuVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = "";
        try {
            str = this.qlC.a() + dw.a(dw.iV(this.qlC.f8147a));
        } catch (UnsupportedEncodingException e) {
        }
        v.a(str, (Map) null, new cn(this));
    }
}
