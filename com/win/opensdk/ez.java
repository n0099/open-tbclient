package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes14.dex */
public class ez implements g {
    public final /* synthetic */ Info qkd;
    public final /* synthetic */ l qke;

    public ez(l lVar, Info info) {
        this.qke = lVar;
        this.qkd = info;
    }

    @Override // com.win.opensdk.g
    public void a(String str) {
    }

    @Override // com.win.opensdk.g
    public boolean a(String str, String str2) {
        l.a(this.qke, this.qkd, str);
        PBBannerListener pBBannerListener = this.qke.qkl;
        if (pBBannerListener != null) {
            pBBannerListener.onClicked();
            return true;
        }
        return true;
    }
}
