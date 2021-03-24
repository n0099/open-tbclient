package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class x implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f40097a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f40098b;

    public x(C c2, Info info) {
        this.f40098b = c2;
        this.f40097a = info;
    }

    @Override // com.win.opensdk.C2
    public void a() {
        C c2 = this.f40098b;
        c2.o.sendEmptyMessageDelayed(100151, c2.f39637d * 1000);
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40098b.o.removeMessages(100151);
        C c2 = this.f40098b;
        c2.a(this.f40097a, c2.m);
        a1.a(this.f40098b.f39636c).a(new b1(this.f40098b.f39641h), 200, System.currentTimeMillis() - this.f40098b.k).a();
        a1.a(this.f40098b.f39636c).b(new b1(this.f40097a)).a();
        C c3 = this.f40098b;
        if (!c3.i) {
            c3.i = true;
            PBBannerListener pBBannerListener = c3.f39640g;
            if (pBBannerListener != null) {
                pBBannerListener.onLoaded();
            }
        }
        G.a(this.f40098b.f39641h);
    }
}
