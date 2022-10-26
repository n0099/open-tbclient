package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
/* loaded from: classes8.dex */
public final class au {
    public static String TAG = "plugin.signature";

    public static Signature[] di(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            String str = TAG;
            com.kwad.sdk.core.e.b.w(str, "Can not get signature, error = " + e.getLocalizedMessage());
            com.kwad.sdk.core.e.b.w(TAG, e);
            return null;
        }
    }

    public static String dj(Context context) {
        try {
            Signature[] di = di(context);
            if (di != null && di.length > 0) {
                return ab.l(di[0].toByteArray());
            }
            return "";
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.w(TAG, e);
            return "";
        }
    }
}
