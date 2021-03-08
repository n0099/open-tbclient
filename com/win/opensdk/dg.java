package com.win.opensdk;
/* loaded from: classes14.dex */
public class dg implements Runnable {
    public final /* synthetic */ dq qlI;
    public final /* synthetic */ PBError qlK;

    public dg(dq dqVar, PBError pBError) {
        this.qlI = dqVar;
        this.qlK = pBError;
    }

    @Override // java.lang.Runnable
    public void run() {
        du duVar = this.qlI.qlS;
        if (duVar != null) {
            duVar.onFail(this.qlK);
        }
    }
}
