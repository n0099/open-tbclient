package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class y implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f40104a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f40105b;

    public y(C c2, Info info) {
        this.f40105b = c2;
        this.f40104a = info;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        C.a(this.f40105b, this.f40104a, str);
        PBBannerListener pBBannerListener = this.f40105b.f39641g;
        if (pBBannerListener != null) {
            pBBannerListener.onClicked();
            return true;
        }
        return true;
    }
}
