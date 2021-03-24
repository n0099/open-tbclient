package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
/* loaded from: classes7.dex */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f40208a;

    public v(Context context) {
        this.f40208a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f40208a.getPackageManager().getPackageInfo(this.f40208a.getPackageName(), 4612);
            u.c(this.f40208a);
            u.d(this.f40208a, packageInfo);
            u.c(this.f40208a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
