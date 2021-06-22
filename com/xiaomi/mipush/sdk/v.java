package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
/* loaded from: classes7.dex */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f41064a;

    public v(Context context) {
        this.f41064a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f41064a.getPackageManager().getPackageInfo(this.f41064a.getPackageName(), 4612);
            u.c(this.f41064a);
            u.d(this.f41064a, packageInfo);
            u.c(this.f41064a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
