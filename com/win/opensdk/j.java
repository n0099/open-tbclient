package com.win.opensdk;

import android.graphics.Bitmap;
/* loaded from: classes6.dex */
public class j implements P {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f37898a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PBSplash f37899b;

    public j(PBSplash pBSplash, Bitmap.CompressFormat compressFormat) {
        this.f37899b = pBSplash;
        this.f37898a = compressFormat;
    }

    public void a(int i2) {
    }

    public void a(O o) {
        PBSplash pBSplash = this.f37899b;
        PBSplashListener pBSplashListener = pBSplash.f37733e;
        if (pBSplashListener == null || pBSplash.j) {
            return;
        }
        pBSplashListener.onFail(PBError.NO_RESUOURCE);
        PBSplash.d(this.f37899b, true);
    }
}
