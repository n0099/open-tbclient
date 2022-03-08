package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.Nullable;
/* loaded from: classes8.dex */
public class ar {
    public static String a = "plugin.signature";

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    public static Signature[] a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
        } catch (PackageManager.NameNotFoundException e2) {
            String str = a;
            com.kwad.sdk.core.d.a.d(str, "Can not get signature, error = " + e2.getLocalizedMessage());
            com.kwad.sdk.core.d.a.a(a, e2);
            return null;
        }
    }

    public static String b(Context context) {
        try {
            Signature[] a2 = a(context);
            if (a2 != null && a2.length >= 1) {
                return aa.a(a2[0].toByteArray());
            }
            return "";
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(a, e2);
            return "";
        }
    }
}
