package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class y implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f40393a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f40394b;

    public y(C c2, Info info) {
        this.f40394b = c2;
        this.f40393a = info;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        C.a(this.f40394b, this.f40393a, str);
        PBBannerListener pBBannerListener = this.f40394b.f39930g;
        if (pBBannerListener != null) {
            pBBannerListener.onClicked();
            return true;
        }
        return true;
    }
}
