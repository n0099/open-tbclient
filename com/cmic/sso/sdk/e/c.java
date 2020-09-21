package com.cmic.sso.sdk.e;

import android.util.Log;
/* loaded from: classes7.dex */
public class c {
    private static final c nti = new c();
    private static boolean b = false;

    public static void a(String str, String str2) {
        if (b) {
            Log.e("CMCC-SDK:" + str, "" + str2);
        }
    }

    public static void b(String str, String str2) {
        if (b) {
            Log.d("CMCC-SDK:" + str, "" + str2);
        }
    }

    public static void c(String str, String str2) {
        if (b) {
            Log.i("CMCC-SDK:" + str, "" + str2);
        }
    }
}
