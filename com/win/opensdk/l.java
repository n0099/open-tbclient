package com.win.opensdk;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f40255a;

    public l(PBSplash pBSplash) {
        this.f40255a = pBSplash;
    }

    public void a(int i, int i2) {
        if (i == 1 && i2 == 0) {
            PBSplash pBSplash = this.f40255a;
            PBSplashListener pBSplashListener = pBSplash.f40053e;
            if (pBSplashListener != null && !pBSplash.f40054f && !pBSplash.k && !PBSplash.isdpl) {
                if (pBSplashListener != null) {
                    pBSplashListener.onTimeOver();
                    return;
                }
                return;
            }
            PBSplash pBSplash2 = this.f40255a;
            if (pBSplash2.f40053e == null || pBSplash2.f40054f || !pBSplash2.k || PBSplash.isdpl) {
                return;
            }
            B1 b1 = pBSplash2.f40050b.f40305a;
            if (((b1 == null || !b1.b()) ? -1 : b1.f39916c.getOpent()) == 1) {
                PBSplash pBSplash3 = this.f40255a;
                if (pBSplash3.f40053e == null || !pBSplash3.r.isShown()) {
                    return;
                }
                this.f40255a.f40053e.onTimeOver();
            }
        }
    }
}
