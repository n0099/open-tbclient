package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class x implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f40482a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f40483b;

    public x(C c2, Info info) {
        this.f40483b = c2;
        this.f40482a = info;
    }

    @Override // com.win.opensdk.C2
    public void a() {
        C c2 = this.f40483b;
        c2.o.sendEmptyMessageDelayed(100151, c2.f40022d * 1000);
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40483b.o.removeMessages(100151);
        C c2 = this.f40483b;
        c2.a(this.f40482a, c2.m);
        a1.a(this.f40483b.f40021c).a(new b1(this.f40483b.f40026h), 200, System.currentTimeMillis() - this.f40483b.k).a();
        a1.a(this.f40483b.f40021c).b(new b1(this.f40482a)).a();
        C c3 = this.f40483b;
        if (!c3.i) {
            c3.i = true;
            PBBannerListener pBBannerListener = c3.f40025g;
            if (pBBannerListener != null) {
                pBBannerListener.onLoaded();
            }
        }
        G.a(this.f40483b.f40026h);
    }
}
