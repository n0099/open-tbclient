package com.win.opensdk;

import android.graphics.Bitmap;
/* loaded from: classes7.dex */
public class j implements P {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f37143a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PBSplash f37144b;

    public j(PBSplash pBSplash, Bitmap.CompressFormat compressFormat) {
        this.f37144b = pBSplash;
        this.f37143a = compressFormat;
    }

    public void a(int i2) {
    }

    public void a(O o) {
        PBSplash pBSplash = this.f37144b;
        PBSplashListener pBSplashListener = pBSplash.f36978e;
        if (pBSplashListener == null || pBSplash.j) {
            return;
        }
        pBSplashListener.onFail(PBError.NO_RESUOURCE);
        PBSplash.d(this.f37144b, true);
    }
}
