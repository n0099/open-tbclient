package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes14.dex */
public class fc implements m {
    public final /* synthetic */ Info qkd;
    public final /* synthetic */ l qke;

    public fc(l lVar, Info info) {
        this.qke = lVar;
        this.qkd = info;
    }

    @Override // com.win.opensdk.m
    public void a() {
        l lVar = this.qke;
        lVar.o.sendEmptyMessageDelayed(100151, lVar.d * 1000);
    }

    @Override // com.win.opensdk.m
    public void onLoaded() {
        this.qke.o.removeMessages(100151);
        l lVar = this.qke;
        lVar.a(this.qkd, lVar.qkn);
        ca.iT(this.qke.c).a(new cd(this.qke.qkm), 200, System.currentTimeMillis() - this.qke.k).a();
        ca.iT(this.qke.c).a(new cd(this.qkd)).a();
        l lVar2 = this.qke;
        if (!lVar2.i) {
            lVar2.i = true;
            PBBannerListener pBBannerListener = lVar2.qkl;
            if (pBBannerListener != null) {
                pBBannerListener.onLoaded();
            }
        }
        v.d(this.qke.qkm);
    }
}
