package com.win.opensdk;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f40757a;

    public l(PBSplash pBSplash) {
        this.f40757a = pBSplash;
    }

    public void a(int i2, int i3) {
        if (i2 == 1 && i3 == 0) {
            PBSplash pBSplash = this.f40757a;
            PBSplashListener pBSplashListener = pBSplash.f40586e;
            if (pBSplashListener != null && !pBSplash.f40587f && !pBSplash.k && !PBSplash.isdpl) {
                if (pBSplashListener != null) {
                    pBSplashListener.onTimeOver();
                    return;
                }
                return;
            }
            PBSplash pBSplash2 = this.f40757a;
            if (pBSplash2.f40586e == null || pBSplash2.f40587f || !pBSplash2.k || PBSplash.isdpl) {
                return;
            }
            Y0 y0 = pBSplash2.f40583b.f40773a;
            if (((y0 == null || !y0.b()) ? -1 : y0.f40662c.getOpent()) == 1) {
                PBSplash pBSplash3 = this.f40757a;
                if (pBSplash3.f40586e == null || !pBSplash3.r.isShown()) {
                    return;
                }
                this.f40757a.f40586e.onTimeOver();
            }
        }
    }
}
