package com.win.opensdk;

import android.content.Context;
/* loaded from: classes7.dex */
public class g implements r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f40821a;

    public g(PBSplash pBSplash) {
        this.f40821a = pBSplash;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        this.f40821a.k = true;
        PBSplashListener pBSplashListener = this.f40821a.f40689e;
        if (pBSplashListener != null) {
            pBSplashListener.onClicked();
        }
    }

    @Override // com.win.opensdk.r
    public void onDisplayed() {
        PBSplashListener pBSplashListener = this.f40821a.f40689e;
        if (pBSplashListener != null) {
            pBSplashListener.onDisplayed();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        if (pBError == PBError.PID_INVALID) {
            PBSplashListener pBSplashListener = this.f40821a.f40689e;
            if (pBSplashListener != null) {
                pBSplashListener.onFail(PBError.NO_FILL);
                return;
            }
            return;
        }
        PBSplash pBSplash = this.f40821a;
        PBSplashListener pBSplashListener2 = pBSplash.f40689e;
        if (pBSplashListener2 == null || pBSplash.j) {
            return;
        }
        pBSplashListener2.onFail(PBError.NO_FILL);
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        if (this.f40821a.f40686b.c()) {
            PBSplash pBSplash = this.f40821a;
            Context context = pBSplash.f40685a;
            Y0 y0 = pBSplash.f40686b.f40876a;
            s1.c(context, (y0 == null || !y0.b()) ? 0L : y0.f40765c.getLo_timeout());
            String str = "";
            if (this.f40821a.f40686b.b().equals("image")) {
                Y0 y02 = this.f40821a.f40686b.f40876a;
                if (y02 != null && y02.b()) {
                    str = y02.f40765c.getLoad();
                }
                this.f40821a.b(str);
            } else if (this.f40821a.f40686b.b().equals("gif")) {
                Y0 y03 = this.f40821a.f40686b.f40876a;
                if (y03 != null && y03.b()) {
                    str = y03.f40765c.getLoad();
                }
                this.f40821a.a(str);
            } else {
                PBSplashListener pBSplashListener = this.f40821a.f40689e;
                if (pBSplashListener != null) {
                    pBSplashListener.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
