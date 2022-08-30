package com.kwad.sdk.utils;

import android.os.Build;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class ap {
    public static String anZ;
    public static String aoa;

    public static boolean aY(String str) {
        String upperCase;
        String str2 = anZ;
        if (str2 != null) {
            return str2.contains(str);
        }
        String str3 = ay.get("ro.build.version.opporom");
        aoa = str3;
        if (TextUtils.isEmpty(str3)) {
            String str4 = ay.get("ro.vivo.os.version");
            aoa = str4;
            if (TextUtils.isEmpty(str4)) {
                String str5 = ay.get("ro.build.version.emui");
                aoa = str5;
                if (TextUtils.isEmpty(str5)) {
                    String str6 = ay.get("ro.miui.ui.version.name");
                    aoa = str6;
                    if (TextUtils.isEmpty(str6)) {
                        String str7 = ay.get("ro.product.system.manufacturer");
                        aoa = str7;
                        if (TextUtils.isEmpty(str7)) {
                            String str8 = ay.get("ro.smartisan.version");
                            aoa = str8;
                            if (TextUtils.isEmpty(str8)) {
                                String str9 = "SAMSUNG";
                                if (!ay.get("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                    String str10 = Build.DISPLAY;
                                    aoa = str10;
                                    str9 = "FLYME";
                                    if (!str10.toUpperCase().contains("FLYME")) {
                                        aoa = "unknown";
                                        upperCase = Build.MANUFACTURER.toUpperCase();
                                    }
                                }
                                anZ = str9;
                                return anZ.contains(str);
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
        anZ = upperCase;
        return anZ.contains(str);
    }

    public static String getName() {
        if (anZ == null) {
            aY("");
        }
        return anZ;
    }

    public static String getVersion() {
        if (aoa == null) {
            aY("");
        }
        return aoa;
    }

    public static boolean zP() {
        return aY("EMUI");
    }

    public static boolean zQ() {
        return aY("MIUI");
    }

    public static boolean zR() {
        return aY("FLYME");
    }
}
