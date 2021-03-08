package com.win.opensdk;
/* loaded from: classes14.dex */
public class di {
    public final /* synthetic */ aw qlL;

    public void a(int i, int i2) {
        if (i == 1 && i2 == 0) {
            aw awVar = this.qlL;
            ax axVar = awVar.qkU;
            if (axVar != null && !awVar.f && !awVar.k && !aw.qkS) {
                if (axVar != null) {
                    axVar.eJb();
                    return;
                }
                return;
            }
            aw awVar2 = this.qlL;
            if (awVar2.qkU != null && !awVar2.f && awVar2.k && !aw.qkS) {
                i iVar = awVar2.qkT.qmb;
                if (((iVar == null || !iVar.b()) ? -1 : iVar.qkh.getOpent()) == 1) {
                    aw awVar3 = this.qlL;
                    if (awVar3.qkU == null || !awVar3.r.isShown()) {
                        return;
                    }
                    this.qlL.qkU.eJb();
                }
            }
        }
    }
}
