package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
/* loaded from: classes7.dex */
public final class ah {
    @RequiresApi(api = 26)
    public static boolean cD(Context context) {
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(th);
            return false;
        }
    }

    @Nullable
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
