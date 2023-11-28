package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public final class bc {
    public static String TAG = "plugin.signature";
    public static Signature[] aOu = new Signature[0];

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    public static Signature[] cS(Context context) {
        Signature[] signatureArr = aOu;
        if (signatureArr != null && signatureArr.length > 0) {
            return signatureArr;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null) {
                aOu = packageInfo.signatures;
            }
        } catch (PackageManager.NameNotFoundException e) {
            String str = TAG;
            com.kwad.sdk.core.e.c.w(str, "Can not get signature, error = " + e.getLocalizedMessage());
            com.kwad.sdk.core.e.c.w(TAG, e);
        }
        return aOu;
    }

    public static String cT(Context context) {
        try {
            Signature[] cS = cS(context);
            if (cS != null && cS.length > 0) {
                return ad.l(cS[0].toByteArray());
            }
            return "";
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.w(TAG, e);
            return "";
        }
    }
}
