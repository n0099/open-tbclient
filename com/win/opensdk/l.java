package com.win.opensdk;
/* loaded from: classes7.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f37078a;

    public l(PBSplash pBSplash) {
        this.f37078a = pBSplash;
    }

    public void a(int i2, int i3) {
        if (i2 == 1 && i3 == 0) {
            PBSplash pBSplash = this.f37078a;
            PBSplashListener pBSplashListener = pBSplash.f36907e;
            if (pBSplashListener != null && !pBSplash.f36908f && !pBSplash.k && !PBSplash.isdpl) {
                if (pBSplashListener != null) {
                    pBSplashListener.onTimeOver();
                    return;
                }
                return;
            }
            PBSplash pBSplash2 = this.f37078a;
            if (pBSplash2.f36907e == null || pBSplash2.f36908f || !pBSplash2.k || PBSplash.isdpl) {
                return;
            }
            Y0 y0 = pBSplash2.f36904b.f37094a;
            if (((y0 == null || !y0.b()) ? -1 : y0.f36983c.getOpent()) == 1) {
                PBSplash pBSplash3 = this.f37078a;
                if (pBSplash3.f36907e == null || !pBSplash3.r.isShown()) {
                    return;
                }
                this.f37078a.f36907e.onTimeOver();
            }
        }
    }
}
