package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes14.dex */
public class de implements du {
    public final /* synthetic */ Cdo qlG;

    public de(Cdo cdo) {
        this.qlG = cdo;
    }

    @Override // com.win.opensdk.du
    public void a() {
    }

    @Override // com.win.opensdk.du
    public void a(Object obj) {
        this.qlG.d((Info) obj);
    }

    @Override // com.win.opensdk.du
    public void onFail(PBError pBError) {
        this.qlG.qlP.onFail(pBError);
    }
}
