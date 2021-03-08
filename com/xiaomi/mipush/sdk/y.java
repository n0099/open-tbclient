package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f8246a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Context context) {
        this.f8246a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f8246a.getPackageManager().getPackageInfo(this.f8246a.getPackageName(), 4612);
            x.c(this.f8246a);
            x.d(this.f8246a, packageInfo);
            x.c(this.f8246a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
