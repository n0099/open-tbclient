package com.win.opensdk;

import android.graphics.Bitmap;
/* loaded from: classes7.dex */
public class j implements X {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap.CompressFormat f40244a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PBSplash f40245b;

    public j(PBSplash pBSplash, Bitmap.CompressFormat compressFormat) {
        this.f40245b = pBSplash;
        this.f40244a = compressFormat;
    }

    public void a(int i) {
    }

    public void a(W w) {
        PBSplash pBSplash = this.f40245b;
        PBSplashListener pBSplashListener = pBSplash.f40053e;
        if (pBSplashListener == null || pBSplash.j) {
            return;
        }
        pBSplashListener.onFail(PBError.NO_RESUOURCE);
        PBSplash.d(this.f40245b, true);
    }
}
