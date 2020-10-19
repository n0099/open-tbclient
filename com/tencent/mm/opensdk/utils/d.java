package com.tencent.mm.opensdk.utils;
/* loaded from: classes11.dex */
public final class d {
    public static boolean a(String str) {
        return str == null || str.length() <= 0;
    }

    public static int b(String str) {
        if (str != null) {
            try {
                if (str.length() <= 0) {
                    return 0;
                }
                return Integer.parseInt(str);
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }
}
