package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public final class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4783a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Context context) {
        this.f4783a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f4783a.getPackageManager().getPackageInfo(this.f4783a.getPackageName(), 4612);
            x.c(this.f4783a);
            x.d(this.f4783a, packageInfo);
            x.c(this.f4783a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
