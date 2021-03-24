package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class A implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f39612a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f39613b;

    public A(C c2, Info info) {
        this.f39613b = c2;
        this.f39612a = info;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        C.a(this.f39613b, this.f39612a, str);
        PBBannerListener pBBannerListener = this.f39613b.f39640g;
        if (pBBannerListener != null) {
            pBBannerListener.onClicked();
            return true;
        }
        return true;
    }
}
