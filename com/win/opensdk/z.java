package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class z implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f40115a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f40116b;

    public z(C c2, Info info) {
        this.f40116b = c2;
        this.f40115a = info;
    }

    @Override // com.win.opensdk.C2
    public void a() {
        C c2 = this.f40116b;
        c2.o.sendEmptyMessageDelayed(100151, c2.f39638d * 1000);
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40116b.o.removeMessages(100151);
        C c2 = this.f40116b;
        c2.a(this.f40115a, c2.l);
        a1.a(this.f40116b.f39637c).a(new b1(this.f40116b.f39642h), 200, System.currentTimeMillis() - this.f40116b.k).a();
        a1.a(this.f40116b.f39637c).b(new b1(this.f40115a)).a();
        C c3 = this.f40116b;
        if (!c3.i) {
            c3.i = true;
            PBBannerListener pBBannerListener = c3.f39641g;
            if (pBBannerListener != null) {
                pBBannerListener.onLoaded();
            }
        }
        G.a(this.f40116b.f39642h);
    }
}
