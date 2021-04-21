package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class y implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f40488a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f40489b;

    public y(C c2, Info info) {
        this.f40489b = c2;
        this.f40488a = info;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        C.a(this.f40489b, this.f40488a, str);
        PBBannerListener pBBannerListener = this.f40489b.f40025g;
        if (pBBannerListener != null) {
            pBBannerListener.onClicked();
            return true;
        }
        return true;
    }
}
