package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4781a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Context context) {
        this.f4781a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f4781a.getPackageManager().getPackageInfo(this.f4781a.getPackageName(), 4612);
            x.c(this.f4781a);
            x.d(this.f4781a, packageInfo);
            x.c(this.f4781a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
