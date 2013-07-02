package org.acra.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
/* loaded from: classes.dex */
public final class g {
    private final Context a;

    public g(Context context) {
        this.a = context;
    }

    public boolean a(String str) {
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            return packageManager.checkPermission(str, this.a.getPackageName()) == 0;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public PackageInfo a() {
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            return packageManager.getPackageInfo(this.a.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.v(org.acra.a.a, "Failed to find PackageInfo for current App : " + this.a.getPackageName());
            return null;
        } catch (RuntimeException e2) {
            return null;
        }
    }
}
