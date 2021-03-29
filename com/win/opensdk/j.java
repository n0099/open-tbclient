package com.win.opensdk;

import android.graphics.Bitmap;
/* loaded from: classes7.dex */
public class j implements X {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f39955a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PBSplash f39956b;

    public j(PBSplash pBSplash, Bitmap.CompressFormat compressFormat) {
        this.f39956b = pBSplash;
        this.f39955a = compressFormat;
    }

    public void a(int i) {
    }

    public void a(W w) {
        PBSplash pBSplash = this.f39956b;
        PBSplashListener pBSplashListener = pBSplash.f39764e;
        if (pBSplashListener == null || pBSplash.j) {
            return;
        }
        pBSplashListener.onFail(PBError.NO_RESUOURCE);
        PBSplash.d(this.f39956b, true);
    }
}
