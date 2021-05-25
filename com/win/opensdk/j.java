package com.win.opensdk;

import android.graphics.Bitmap;
/* loaded from: classes7.dex */
public class j implements P {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f37072a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PBSplash f37073b;

    public j(PBSplash pBSplash, Bitmap.CompressFormat compressFormat) {
        this.f37073b = pBSplash;
        this.f37072a = compressFormat;
    }

    public void a(int i2) {
    }

    public void a(O o) {
        PBSplash pBSplash = this.f37073b;
        PBSplashListener pBSplashListener = pBSplash.f36907e;
        if (pBSplashListener == null || pBSplash.j) {
            return;
        }
        pBSplashListener.onFail(PBError.NO_RESUOURCE);
        PBSplash.d(this.f37073b, true);
    }
}
