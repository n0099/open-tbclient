package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class z implements C2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f40114a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f40115b;

    public z(C c2, Info info) {
        this.f40115b = c2;
        this.f40114a = info;
    }

    @Override // com.win.opensdk.C2
    public void a() {
        C c2 = this.f40115b;
        c2.o.sendEmptyMessageDelayed(100151, c2.f39637d * 1000);
    }

    @Override // com.win.opensdk.C2
    public void onLoaded() {
        this.f40115b.o.removeMessages(100151);
        C c2 = this.f40115b;
        c2.a(this.f40114a, c2.l);
        a1.a(this.f40115b.f39636c).a(new b1(this.f40115b.f39641h), 200, System.currentTimeMillis() - this.f40115b.k).a();
        a1.a(this.f40115b.f39636c).b(new b1(this.f40114a)).a();
        C c3 = this.f40115b;
        if (!c3.i) {
            c3.i = true;
            PBBannerListener pBBannerListener = c3.f39640g;
            if (pBBannerListener != null) {
                pBBannerListener.onLoaded();
            }
        }
        G.a(this.f40115b.f39641h);
    }
}
