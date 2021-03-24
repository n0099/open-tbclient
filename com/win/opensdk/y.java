package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class y implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f40103a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f40104b;

    public y(C c2, Info info) {
        this.f40104b = c2;
        this.f40103a = info;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        C.a(this.f40104b, this.f40103a, str);
        PBBannerListener pBBannerListener = this.f40104b.f39640g;
        if (pBBannerListener != null) {
            pBBannerListener.onClicked();
            return true;
        }
        return true;
    }
}
