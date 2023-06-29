package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes10.dex */
public final class g {
    public static String a = "autoRevert";

    public static String a(Context context) {
        return t.d(context, "curversion", "");
    }

    public static void a(Context context, String str) {
        t.c(context, "curversion", str);
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
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
            return split.length > split2.length;
        }
        return true;
    }

    public static String b(Context context) {
        return t.d(context, "newversion", "");
    }

    public static void b(Context context, String str) {
        t.c(context, "newversion", str);
    }

    public static String c(Context context) {
        return t.d(context, "apiversion", "");
    }

    public static void c(Context context, String str) {
        t.c(context, "apiversion", str);
    }
}
