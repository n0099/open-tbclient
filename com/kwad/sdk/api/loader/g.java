package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes10.dex */
public final class g {
    public static String alK = "autoRevert";

    public static boolean G(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        for (int i = 0; i < split.length && i < split2.length; i++) {
            try {
                int parseInt = Integer.parseInt(split[i]) - Integer.parseInt(split2[i]);
                if (parseInt > 0) {
                    return true;
                }
                if (parseInt < 0) {
                    return false;
                }
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        if (split.length <= split2.length) {
            return false;
        }
        return true;
    }

    public static String aA(Context context) {
        return getVersion(context, "apiversion");
    }

    public static String ay(Context context) {
        return getVersion(context, "curversion");
    }

    public static String az(Context context) {
        return getVersion(context, "newversion");
    }

    public static void d(Context context, String str, String str2) {
        t.b(context, str, str2);
    }

    public static String getVersion(Context context, String str) {
        return t.c(context, str, "");
    }

    public static void m(Context context, String str) {
        d(context, "curversion", str);
    }

    public static void n(Context context, String str) {
        d(context, "newversion", str);
    }

    public static void o(Context context, String str) {
        d(context, "apiversion", str);
    }
}
