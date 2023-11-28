package com.kwad.sdk.utils;
/* loaded from: classes10.dex */
public final class i {
    public static void an(String str, String str2) {
        com.kwad.sdk.core.e.c.d("callbackLog", str + str2);
    }

    public static void s(String str, int i) {
        com.kwad.sdk.core.e.c.d("audioVideoLog", str + "_type_" + i + "_time_" + System.currentTimeMillis());
    }

    public static void e(String str, String str2, String str3, String str4) {
        an(str, str2 + "_" + str3 + "_" + str4);
    }
}
