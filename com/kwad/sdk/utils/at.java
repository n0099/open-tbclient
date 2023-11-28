package com.kwad.sdk.utils;

import android.os.Build;
import android.text.TextUtils;
/* loaded from: classes10.dex */
public final class at {
    public static String aNZ;
    public static String aOa;

    public static boolean KB() {
        return ga("EMUI");
    }

    public static boolean KC() {
        return ga("MIUI");
    }

    public static boolean KD() {
        return ga("FLYME");
    }

    public static String getName() {
        if (aNZ == null) {
            ga("");
        }
        return aNZ;
    }

    public static String getVersion() {
        if (aOa == null) {
            ga("");
        }
        return aOa;
    }

    public static boolean ga(String str) {
        String str2 = aNZ;
        if (str2 != null) {
            return str2.contains(str);
        }
        String str3 = bh.get("ro.build.version.opporom");
        aOa = str3;
        if (!TextUtils.isEmpty(str3)) {
            aNZ = "OPPO";
        } else {
            String str4 = bh.get("ro.vivo.os.version");
            aOa = str4;
            if (!TextUtils.isEmpty(str4)) {
                aNZ = "VIVO";
            } else {
                String str5 = bh.get("ro.build.version.emui");
                aOa = str5;
                if (!TextUtils.isEmpty(str5)) {
                    aNZ = "EMUI";
                } else {
                    String str6 = bh.get("ro.miui.ui.version.name");
                    aOa = str6;
                    if (!TextUtils.isEmpty(str6)) {
                        aNZ = "MIUI";
                    } else {
                        String str7 = bh.get("ro.product.system.manufacturer");
                        aOa = str7;
                        if (!TextUtils.isEmpty(str7)) {
                            aNZ = "OnePlus";
                        } else {
                            String str8 = bh.get("ro.smartisan.version");
                            aOa = str8;
                            if (!TextUtils.isEmpty(str8)) {
                                aNZ = "SMARTISAN";
                            } else if (bh.get("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                aNZ = "SAMSUNG";
                            } else {
                                String str9 = Build.DISPLAY;
                                aOa = str9;
                                if (str9.toUpperCase().contains("FLYME")) {
                                    aNZ = "FLYME";
                                } else {
                                    aOa = "unknown";
                                    aNZ = Build.MANUFACTURER.toUpperCase();
                                }
                            }
                        }
                    }
                }
            }
        }
        return aNZ.contains(str);
    }
}
