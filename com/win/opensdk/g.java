package com.win.opensdk;

import android.content.Context;
/* loaded from: classes6.dex */
public class g implements r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f37865a;

    public g(PBSplash pBSplash) {
        this.f37865a = pBSplash;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        this.f37865a.k = true;
        PBSplashListener pBSplashListener = this.f37865a.f37733e;
        if (pBSplashListener != null) {
            pBSplashListener.onClicked();
        }
    }

    @Override // com.win.opensdk.r
    public void onDisplayed() {
        PBSplashListener pBSplashListener = this.f37865a.f37733e;
        if (pBSplashListener != null) {
            pBSplashListener.onDisplayed();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        if (pBError == PBError.PID_INVALID) {
            PBSplashListener pBSplashListener = this.f37865a.f37733e;
            if (pBSplashListener != null) {
                pBSplashListener.onFail(PBError.NO_FILL);
                return;
            }
            return;
        }
        PBSplash pBSplash = this.f37865a;
        PBSplashListener pBSplashListener2 = pBSplash.f37733e;
        if (pBSplashListener2 == null || pBSplash.j) {
            return;
        }
        pBSplashListener2.onFail(PBError.NO_FILL);
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        if (this.f37865a.f37730b.c()) {
            PBSplash pBSplash = this.f37865a;
            Context context = pBSplash.f37729a;
            Y0 y0 = pBSplash.f37730b.f37920a;
            s1.c(context, (y0 == null || !y0.b()) ? 0L : y0.f37809c.getLo_timeout());
            String str = "";
            if (this.f37865a.f37730b.b().equals("image")) {
                Y0 y02 = this.f37865a.f37730b.f37920a;
                if (y02 != null && y02.b()) {
                    str = y02.f37809c.getLoad();
                }
                this.f37865a.b(str);
            } else if (this.f37865a.f37730b.b().equals("gif")) {
                Y0 y03 = this.f37865a.f37730b.f37920a;
                if (y03 != null && y03.b()) {
                    str = y03.f37809c.getLoad();
                }
                this.f37865a.a(str);
            } else {
                PBSplashListener pBSplashListener = this.f37865a.f37733e;
                if (pBSplashListener != null) {
                    pBSplashListener.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
