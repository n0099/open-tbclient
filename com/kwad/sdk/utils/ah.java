package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
/* loaded from: classes8.dex */
public final class ah {
    public static boolean cD(Context context) {
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            return false;
        }
    }

    public static String[] cE(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            if (packageInfo != null) {
                return packageInfo.requestedPermissions;
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            return null;
        }
    }
}
