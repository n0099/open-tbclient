package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class y implements Runnable {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 4612);
            x.c(this.a);
            x.d(this.a, packageInfo);
            x.c(this.a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
