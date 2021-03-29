package com.win.opensdk;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f39966a;

    public l(PBSplash pBSplash) {
        this.f39966a = pBSplash;
    }

    public void a(int i, int i2) {
        if (i == 1 && i2 == 0) {
            PBSplash pBSplash = this.f39966a;
            PBSplashListener pBSplashListener = pBSplash.f39764e;
            if (pBSplashListener != null && !pBSplash.f39765f && !pBSplash.k && !PBSplash.isdpl) {
                if (pBSplashListener != null) {
                    pBSplashListener.onTimeOver();
                    return;
                }
                return;
            }
            PBSplash pBSplash2 = this.f39966a;
            if (pBSplash2.f39764e == null || pBSplash2.f39765f || !pBSplash2.k || PBSplash.isdpl) {
                return;
            }
            B1 b1 = pBSplash2.f39761b.f40016a;
            if (((b1 == null || !b1.b()) ? -1 : b1.f39627c.getOpent()) == 1) {
                PBSplash pBSplash3 = this.f39966a;
                if (pBSplash3.f39764e == null || !pBSplash3.r.isShown()) {
                    return;
                }
                this.f39966a.f39764e.onTimeOver();
            }
        }
    }
}
