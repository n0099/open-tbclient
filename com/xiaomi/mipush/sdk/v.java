package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
/* loaded from: classes7.dex */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f37282a;

    public v(Context context) {
        this.f37282a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f37282a.getPackageManager().getPackageInfo(this.f37282a.getPackageName(), 4612);
            u.c(this.f37282a);
            u.d(this.f37282a, packageInfo);
            u.c(this.f37282a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
