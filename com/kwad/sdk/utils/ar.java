package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public final class ar {
    public static String a = "plugin.signature";

    public static String a(Context context) {
        try {
            Signature[] b = b(context);
            if (b != null && b.length > 0) {
                return z.a(b[0].toByteArray());
            }
            return "";
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(a, e);
            return "";
        }
    }

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    public static Signature[] b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            String str = a;
            com.kwad.sdk.core.d.b.d(str, "Can not get signature, error = " + e.getLocalizedMessage());
            com.kwad.sdk.core.d.b.a(a, e);
            return null;
        }
    }
}
