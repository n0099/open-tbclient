package com.win.opensdk;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f39965a;

    public l(PBSplash pBSplash) {
        this.f39965a = pBSplash;
    }

    public void a(int i, int i2) {
        if (i == 1 && i2 == 0) {
            PBSplash pBSplash = this.f39965a;
            PBSplashListener pBSplashListener = pBSplash.f39763e;
            if (pBSplashListener != null && !pBSplash.f39764f && !pBSplash.k && !PBSplash.isdpl) {
                if (pBSplashListener != null) {
                    pBSplashListener.onTimeOver();
                    return;
                }
                return;
            }
            PBSplash pBSplash2 = this.f39965a;
            if (pBSplash2.f39763e == null || pBSplash2.f39764f || !pBSplash2.k || PBSplash.isdpl) {
                return;
            }
            B1 b1 = pBSplash2.f39760b.f40015a;
            if (((b1 == null || !b1.b()) ? -1 : b1.f39626c.getOpent()) == 1) {
                PBSplash pBSplash3 = this.f39965a;
                if (pBSplash3.f39763e == null || !pBSplash3.r.isShown()) {
                    return;
                }
                this.f39965a.f39763e.onTimeOver();
            }
        }
    }
}
