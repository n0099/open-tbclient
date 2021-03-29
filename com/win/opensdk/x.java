package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class x implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f40098a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f40099b;

    public x(C c2, Info info) {
        this.f40099b = c2;
        this.f40098a = info;
    }

    @Override // com.win.opensdk.C2
    public void a() {
        C c2 = this.f40099b;
        c2.o.sendEmptyMessageDelayed(100151, c2.f39638d * 1000);
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40099b.o.removeMessages(100151);
        C c2 = this.f40099b;
        c2.a(this.f40098a, c2.m);
        a1.a(this.f40099b.f39637c).a(new b1(this.f40099b.f39642h), 200, System.currentTimeMillis() - this.f40099b.k).a();
        a1.a(this.f40099b.f39637c).b(new b1(this.f40098a)).a();
        C c3 = this.f40099b;
        if (!c3.i) {
            c3.i = true;
            PBBannerListener pBBannerListener = c3.f39641g;
            if (pBBannerListener != null) {
                pBBannerListener.onLoaded();
            }
        }
        G.a(this.f40099b.f39642h);
    }
}
