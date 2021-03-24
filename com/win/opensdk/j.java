package com.win.opensdk;

import android.graphics.Bitmap;
/* loaded from: classes7.dex */
public class j implements X {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f39954a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PBSplash f39955b;

    public j(PBSplash pBSplash, Bitmap.CompressFormat compressFormat) {
        this.f39955b = pBSplash;
        this.f39954a = compressFormat;
    }

    public void a(int i) {
    }

    public void a(W w) {
        PBSplash pBSplash = this.f39955b;
        PBSplashListener pBSplashListener = pBSplash.f39763e;
        if (pBSplashListener == null || pBSplash.j) {
            return;
        }
        pBSplashListener.onFail(PBError.NO_RESUOURCE);
        PBSplash.d(this.f39955b, true);
    }
}
