package com.win.opensdk;
/* loaded from: classes14.dex */
public class dl implements m {
    public final /* synthetic */ Cdo qlG;

    public dl(Cdo cdo) {
        this.qlG = cdo;
    }

    @Override // com.win.opensdk.m
    public void a() {
    }

    @Override // com.win.opensdk.m
    public void onLoaded() {
        this.qlG.k.removeMessages(11);
        this.qlG.d = true;
        ca.iT(this.qlG.b).a(new cd(this.qlG.qlN), 200, System.currentTimeMillis() - this.qlG.j).a();
        Cdo cdo = this.qlG;
        if (cdo.e) {
            return;
        }
        cdo.qlP.onLoaded();
    }
}
