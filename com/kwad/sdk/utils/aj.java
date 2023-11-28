package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
/* loaded from: classes10.dex */
public final class aj {
    public static String[] requestedPermissions = new String[0];

    @RequiresApi(api = 26)
    public static boolean cp(Context context) {
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return false;
        }
    }

    @Nullable
    public static String[] cq(Context context) {
        String[] strArr = requestedPermissions;
        if (strArr != null && strArr.length > 0) {
            return strArr;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            if (packageInfo != null) {
                String[] strArr2 = packageInfo.requestedPermissions;
                requestedPermissions = strArr2;
                return strArr2;
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }
}
