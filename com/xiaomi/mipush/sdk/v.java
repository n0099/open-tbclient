package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
/* loaded from: classes7.dex */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f40961a;

    public v(Context context) {
        this.f40961a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f40961a.getPackageManager().getPackageInfo(this.f40961a.getPackageName(), 4612);
            u.c(this.f40961a);
            u.d(this.f40961a, packageInfo);
            u.c(this.f40961a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
