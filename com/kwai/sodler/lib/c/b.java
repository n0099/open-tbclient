package com.kwai.sodler.lib.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f37922a = "plugin.signature";

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    public static Signature[] a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
        } catch (PackageManager.NameNotFoundException e2) {
            String str = f37922a;
            com.kwai.sodler.lib.a.e(str, "Can not get signature, error = " + e2.getLocalizedMessage());
            com.kwai.sodler.lib.a.a(f37922a, e2);
            return null;
        }
    }

    public static String b(Context context) {
        try {
            Signature[] a2 = a(context);
            if (a2 != null && a2.length >= 1) {
                return t.a(a2[0].toByteArray());
            }
            return "";
        } catch (Exception e2) {
            com.kwai.sodler.lib.a.a(f37922a, e2);
            return "";
        }
    }
}
