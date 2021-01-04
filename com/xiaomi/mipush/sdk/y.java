package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f14143a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Context context) {
        this.f14143a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f14143a.getPackageManager().getPackageInfo(this.f14143a.getPackageName(), 4612);
            x.c(this.f14143a);
            x.d(this.f14143a, packageInfo);
            x.c(this.f14143a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
