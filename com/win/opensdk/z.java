package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class z implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f40404a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f40405b;

    public z(C c2, Info info) {
        this.f40405b = c2;
        this.f40404a = info;
    }

    @Override // com.win.opensdk.C2
    public void a() {
        C c2 = this.f40405b;
        c2.o.sendEmptyMessageDelayed(100151, c2.f39927d * 1000);
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40405b.o.removeMessages(100151);
        C c2 = this.f40405b;
        c2.a(this.f40404a, c2.l);
        a1.a(this.f40405b.f39926c).a(new b1(this.f40405b.f39931h), 200, System.currentTimeMillis() - this.f40405b.k).a();
        a1.a(this.f40405b.f39926c).b(new b1(this.f40404a)).a();
        C c3 = this.f40405b;
        if (!c3.i) {
            c3.i = true;
            PBBannerListener pBBannerListener = c3.f39930g;
            if (pBBannerListener != null) {
                pBBannerListener.onLoaded();
            }
        }
        G.a(this.f40405b.f39931h);
    }
}
