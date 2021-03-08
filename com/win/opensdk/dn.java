package com.win.opensdk;
/* loaded from: classes14.dex */
public class dn implements Runnable {
    public final /* synthetic */ dq qlF;

    public dn(dq dqVar) {
        this.qlF = dqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        du duVar = this.qlF.qlS;
        if (duVar != null) {
            duVar.a();
        }
    }
}
