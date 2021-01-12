package com.kwai.sodler.lib.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f11007a = "plugin.signature";

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    public static Signature[] a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
        } catch (PackageManager.NameNotFoundException e) {
            com.kwai.sodler.lib.a.e(f11007a, "Can not get signature, error = " + e.getLocalizedMessage());
            com.kwai.sodler.lib.a.a(f11007a, e);
            return null;
        }
    }

    public static String b(Context context) {
        try {
            Signature[] a2 = a(context);
            return (a2 == null || a2.length < 1) ? "" : t.a(a2[0].toByteArray());
        } catch (Exception e) {
            com.kwai.sodler.lib.a.a(f11007a, e);
            return "";
        }
    }
}
