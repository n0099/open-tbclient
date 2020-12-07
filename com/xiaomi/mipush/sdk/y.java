package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public final class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4553a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Context context) {
        this.f4553a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f4553a.getPackageManager().getPackageInfo(this.f4553a.getPackageName(), 4612);
            x.c(this.f4553a);
            x.d(this.f4553a, packageInfo);
            x.c(this.f4553a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
