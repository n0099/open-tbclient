package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class x implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f40387a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f40388b;

    public x(C c2, Info info) {
        this.f40388b = c2;
        this.f40387a = info;
    }

    @Override // com.win.opensdk.C2
    public void a() {
        C c2 = this.f40388b;
        c2.o.sendEmptyMessageDelayed(100151, c2.f39927d * 1000);
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40388b.o.removeMessages(100151);
        C c2 = this.f40388b;
        c2.a(this.f40387a, c2.m);
        a1.a(this.f40388b.f39926c).a(new b1(this.f40388b.f39931h), 200, System.currentTimeMillis() - this.f40388b.k).a();
        a1.a(this.f40388b.f39926c).b(new b1(this.f40387a)).a();
        C c3 = this.f40388b;
        if (!c3.i) {
            c3.i = true;
            PBBannerListener pBBannerListener = c3.f39930g;
            if (pBBannerListener != null) {
                pBBannerListener.onLoaded();
            }
        }
        G.a(this.f40388b.f39931h);
    }
}
