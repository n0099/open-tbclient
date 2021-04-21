package com.win.opensdk;

import android.content.Context;
/* loaded from: classes7.dex */
public class g implements r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f40316a;

    public g(PBSplash pBSplash) {
        this.f40316a = pBSplash;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        this.f40316a.k = true;
        PBSplashListener pBSplashListener = this.f40316a.f40148e;
        if (pBSplashListener != null) {
            pBSplashListener.onClicked();
        }
    }

    @Override // com.win.opensdk.r
    public void onDisplayed() {
        PBSplashListener pBSplashListener = this.f40316a.f40148e;
        if (pBSplashListener != null) {
            pBSplashListener.onDisplayed();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        if (pBError == PBError.PID_INVALID) {
            PBSplashListener pBSplashListener = this.f40316a.f40148e;
            if (pBSplashListener != null) {
                pBSplashListener.onFail(PBError.NO_FILL);
                return;
            }
            return;
        }
        PBSplash pBSplash = this.f40316a;
        PBSplashListener pBSplashListener2 = pBSplash.f40148e;
        if (pBSplashListener2 == null || pBSplash.j) {
            return;
        }
        pBSplashListener2.onFail(PBError.NO_FILL);
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        if (this.f40316a.f40145b.c()) {
            PBSplash pBSplash = this.f40316a;
            Context context = pBSplash.f40144a;
            B1 b1 = pBSplash.f40145b.f40400a;
            V1.c(context, (b1 == null || !b1.b()) ? 0L : b1.f40011c.getLo_timeout());
            String str = "";
            if (this.f40316a.f40145b.b().equals("image")) {
                B1 b12 = this.f40316a.f40145b.f40400a;
                if (b12 != null && b12.b()) {
                    str = b12.f40011c.getLoad();
                }
                this.f40316a.b(str);
            } else if (this.f40316a.f40145b.b().equals("gif")) {
                B1 b13 = this.f40316a.f40145b.f40400a;
                if (b13 != null && b13.b()) {
                    str = b13.f40011c.getLoad();
                }
                this.f40316a.a(str);
            } else {
                PBSplashListener pBSplashListener = this.f40316a.f40148e;
                if (pBSplashListener != null) {
                    pBSplashListener.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
