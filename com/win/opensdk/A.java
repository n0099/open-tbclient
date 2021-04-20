package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class A implements A2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f39902a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f39903b;

    public A(C c2, Info info) {
        this.f39903b = c2;
        this.f39902a = info;
    }

    @Override // com.win.opensdk.A2
    public void a(String str) {
    }

    @Override // com.win.opensdk.A2
    public boolean a(String str, String str2) {
        C.a(this.f39903b, this.f39902a, str);
        PBBannerListener pBBannerListener = this.f39903b.f39930g;
        if (pBBannerListener != null) {
            pBBannerListener.onClicked();
            return true;
        }
        return true;
    }
}
