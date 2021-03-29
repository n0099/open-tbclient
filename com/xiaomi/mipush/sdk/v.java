package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
/* loaded from: classes7.dex */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f40209a;

    public v(Context context) {
        this.f40209a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f40209a.getPackageManager().getPackageInfo(this.f40209a.getPackageName(), 4612);
            u.c(this.f40209a);
            u.d(this.f40209a, packageInfo);
            u.c(this.f40209a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
