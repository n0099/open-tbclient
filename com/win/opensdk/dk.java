package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes14.dex */
public class dk implements Runnable {
    public final /* synthetic */ Info qkd;
    public final /* synthetic */ dq qlI;

    public dk(dq dqVar, Info info) {
        this.qlI = dqVar;
        this.qkd = info;
    }

    @Override // java.lang.Runnable
    public void run() {
        du duVar = this.qlI.qlS;
        if (duVar != null) {
            duVar.a(this.qkd);
        }
    }
}
