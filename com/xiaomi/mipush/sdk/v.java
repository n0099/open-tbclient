package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
/* loaded from: classes7.dex */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f37353a;

    public v(Context context) {
        this.f37353a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f37353a.getPackageManager().getPackageInfo(this.f37353a.getPackageName(), 4612);
            u.c(this.f37353a);
            u.d(this.f37353a, packageInfo);
            u.c(this.f37353a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
