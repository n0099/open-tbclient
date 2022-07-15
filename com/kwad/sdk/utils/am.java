package com.kwad.sdk.utils;

import android.os.Build;
import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class am {
    public static String a;
    public static String b;

    public static boolean a() {
        return a("EMUI");
    }

    public static boolean a(String str) {
        String upperCase;
        String str2 = a;
        if (str2 != null) {
            return str2.contains(str);
        }
        String a2 = au.a("ro.build.version.opporom");
        b = a2;
        if (TextUtils.isEmpty(a2)) {
            String a3 = au.a("ro.vivo.os.version");
            b = a3;
            if (TextUtils.isEmpty(a3)) {
                String a4 = au.a("ro.build.version.emui");
                b = a4;
                if (TextUtils.isEmpty(a4)) {
                    String a5 = au.a("ro.miui.ui.version.name");
                    b = a5;
                    if (TextUtils.isEmpty(a5)) {
                        String a6 = au.a("ro.product.system.manufacturer");
                        b = a6;
                        if (TextUtils.isEmpty(a6)) {
                            String a7 = au.a("ro.smartisan.version");
                            b = a7;
                            if (TextUtils.isEmpty(a7)) {
                                String str3 = "SAMSUNG";
                                if (!au.a("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                    String str4 = Build.DISPLAY;
                                    b = str4;
                                    str3 = "FLYME";
                                    if (!str4.toUpperCase().contains("FLYME")) {
                                        b = "unknown";
                                        upperCase = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                                a = str3;
                                return a.contains(str);
                            }
                            upperCase = "SMARTISAN";
                        } else {
                            upperCase = "OnePlus";
                        }
                    } else {
                        upperCase = "MIUI";
                    }
                } else {
                    upperCase = "EMUI";
                }
            } else {
                upperCase = "VIVO";
            }
        } else {
            upperCase = "OPPO";
        }
        a = upperCase;
        return a.contains(str);
    }

    public static boolean b() {
        return a("MIUI");
    }

    public static boolean c() {
        return a("FLYME");
    }

    public static String d() {
        if (a == null) {
            a("");
        }
        return a;
    }

    public static String e() {
        if (b == null) {
            a("");
        }
        return b;
    }
}
