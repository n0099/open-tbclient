package com.win.opensdk;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f40350a;

    public l(PBSplash pBSplash) {
        this.f40350a = pBSplash;
    }

    public void a(int i, int i2) {
        if (i == 1 && i2 == 0) {
            PBSplash pBSplash = this.f40350a;
            PBSplashListener pBSplashListener = pBSplash.f40148e;
            if (pBSplashListener != null && !pBSplash.f40149f && !pBSplash.k && !PBSplash.isdpl) {
                if (pBSplashListener != null) {
                    pBSplashListener.onTimeOver();
                    return;
                }
                return;
            }
            PBSplash pBSplash2 = this.f40350a;
            if (pBSplash2.f40148e == null || pBSplash2.f40149f || !pBSplash2.k || PBSplash.isdpl) {
                return;
            }
            B1 b1 = pBSplash2.f40145b.f40400a;
            if (((b1 == null || !b1.b()) ? -1 : b1.f40011c.getOpent()) == 1) {
                PBSplash pBSplash3 = this.f40350a;
                if (pBSplash3.f40148e == null || !pBSplash3.r.isShown()) {
                    return;
                }
                this.f40350a.f40148e.onTimeOver();
            }
        }
    }
}
