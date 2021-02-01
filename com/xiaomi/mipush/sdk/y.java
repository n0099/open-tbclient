package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f13846a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Context context) {
        this.f13846a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f13846a.getPackageManager().getPackageInfo(this.f13846a.getPackageName(), 4612);
            x.c(this.f13846a);
            x.d(this.f13846a, packageInfo);
            x.c(this.f13846a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
