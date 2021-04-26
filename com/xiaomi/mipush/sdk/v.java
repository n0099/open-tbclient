package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
/* loaded from: classes7.dex */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f38108a;

    public v(Context context) {
        this.f38108a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f38108a.getPackageManager().getPackageInfo(this.f38108a.getPackageName(), 4612);
            u.c(this.f38108a);
            u.d(this.f38108a, packageInfo);
            u.c(this.f38108a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
