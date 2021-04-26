package com.win.opensdk;
/* loaded from: classes6.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f37904a;

    public l(PBSplash pBSplash) {
        this.f37904a = pBSplash;
    }

    public void a(int i2, int i3) {
        if (i2 == 1 && i3 == 0) {
            PBSplash pBSplash = this.f37904a;
            PBSplashListener pBSplashListener = pBSplash.f37733e;
            if (pBSplashListener != null && !pBSplash.f37734f && !pBSplash.k && !PBSplash.isdpl) {
                if (pBSplashListener != null) {
                    pBSplashListener.onTimeOver();
                    return;
                }
                return;
            }
            PBSplash pBSplash2 = this.f37904a;
            if (pBSplash2.f37733e == null || pBSplash2.f37734f || !pBSplash2.k || PBSplash.isdpl) {
                return;
            }
            Y0 y0 = pBSplash2.f37730b.f37920a;
            if (((y0 == null || !y0.b()) ? -1 : y0.f37809c.getOpent()) == 1) {
                PBSplash pBSplash3 = this.f37904a;
                if (pBSplash3.f37733e == null || !pBSplash3.r.isShown()) {
                    return;
                }
                this.f37904a.f37733e.onTimeOver();
            }
        }
    }
}
