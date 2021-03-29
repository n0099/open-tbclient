package com.win.opensdk;

import android.content.Context;
/* loaded from: classes7.dex */
public class g implements r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f39932a;

    public g(PBSplash pBSplash) {
        this.f39932a = pBSplash;
    }

    @Override // com.win.opensdk.PBListener
    public void onClicked() {
        this.f39932a.k = true;
        PBSplashListener pBSplashListener = this.f39932a.f39764e;
        if (pBSplashListener != null) {
            pBSplashListener.onClicked();
        }
    }

    @Override // com.win.opensdk.r
    public void onDisplayed() {
        PBSplashListener pBSplashListener = this.f39932a.f39764e;
        if (pBSplashListener != null) {
            pBSplashListener.onDisplayed();
        }
    }

    @Override // com.win.opensdk.PBListener
    public void onFail(PBError pBError) {
        if (pBError == PBError.PID_INVALID) {
            PBSplashListener pBSplashListener = this.f39932a.f39764e;
            if (pBSplashListener != null) {
                pBSplashListener.onFail(PBError.NO_FILL);
                return;
            }
            return;
        }
        PBSplash pBSplash = this.f39932a;
        PBSplashListener pBSplashListener2 = pBSplash.f39764e;
        if (pBSplashListener2 == null || pBSplash.j) {
            return;
        }
        pBSplashListener2.onFail(PBError.NO_FILL);
    }

    @Override // com.win.opensdk.PBListener
    public void onLoaded() {
        if (this.f39932a.f39761b.c()) {
            PBSplash pBSplash = this.f39932a;
            Context context = pBSplash.f39760a;
            B1 b1 = pBSplash.f39761b.f40016a;
            V1.c(context, (b1 == null || !b1.b()) ? 0L : b1.f39627c.getLo_timeout());
            String str = "";
            if (this.f39932a.f39761b.b().equals("image")) {
                B1 b12 = this.f39932a.f39761b.f40016a;
                if (b12 != null && b12.b()) {
                    str = b12.f39627c.getLoad();
                }
                this.f39932a.b(str);
            } else if (this.f39932a.f39761b.b().equals("gif")) {
                B1 b13 = this.f39932a.f39761b.f40016a;
                if (b13 != null && b13.b()) {
                    str = b13.f39627c.getLoad();
                }
                this.f39932a.a(str);
            } else {
                PBSplashListener pBSplashListener = this.f39932a.f39764e;
                if (pBSplashListener != null) {
                    pBSplashListener.onFail(PBError.LOAD_TYPE_ERROR);
                }
            }
        }
    }
}
