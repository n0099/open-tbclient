package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes14.dex */
public class er implements du {
    public final /* synthetic */ fa qml;

    public er(fa faVar) {
        this.qml = faVar;
    }

    @Override // com.win.opensdk.du
    public void a() {
    }

    @Override // com.win.opensdk.du
    public void a(Object obj) {
        fa.a(this.qml, (Info) obj);
    }

    @Override // com.win.opensdk.du
    public void onFail(PBError pBError) {
        this.qml.qmx.onFail(pBError);
    }
}
