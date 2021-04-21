package com.win.opensdk;

import android.graphics.Bitmap;
/* loaded from: classes7.dex */
public class j implements X {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f40339a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PBSplash f40340b;

    public j(PBSplash pBSplash, Bitmap.CompressFormat compressFormat) {
        this.f40340b = pBSplash;
        this.f40339a = compressFormat;
    }

    public void a(int i) {
    }

    public void a(W w) {
        PBSplash pBSplash = this.f40340b;
        PBSplashListener pBSplashListener = pBSplash.f40148e;
        if (pBSplashListener == null || pBSplash.j) {
            return;
        }
        pBSplashListener.onFail(PBError.NO_RESUOURCE);
        PBSplash.d(this.f40340b, true);
    }
}
