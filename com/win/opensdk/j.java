package com.win.opensdk;

import android.graphics.Bitmap;
/* loaded from: classes7.dex */
public class j implements P {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f40854a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PBSplash f40855b;

    public j(PBSplash pBSplash, Bitmap.CompressFormat compressFormat) {
        this.f40855b = pBSplash;
        this.f40854a = compressFormat;
    }

    public void a(int i2) {
    }

    public void a(O o) {
        PBSplash pBSplash = this.f40855b;
        PBSplashListener pBSplashListener = pBSplash.f40689e;
        if (pBSplashListener == null || pBSplash.j) {
            return;
        }
        pBSplashListener.onFail(PBError.NO_RESUOURCE);
        PBSplash.d(this.f40855b, true);
    }
}
