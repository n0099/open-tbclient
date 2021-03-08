package com.win.opensdk;
/* loaded from: classes14.dex */
public class ex implements m {
    public final /* synthetic */ fa qml;

    public ex(fa faVar) {
        this.qml = faVar;
    }

    @Override // com.win.opensdk.m
    public void a() {
    }

    @Override // com.win.opensdk.m
    public void onLoaded() {
        this.qml.k.removeMessages(11);
        this.qml.d = true;
        ca.iT(this.qml.b).a(new cd(this.qml.qlN), 200, System.currentTimeMillis() - this.qml.j).a();
        fa faVar = this.qml;
        if (faVar.e) {
            return;
        }
        faVar.qmx.onLoaded();
    }
}
