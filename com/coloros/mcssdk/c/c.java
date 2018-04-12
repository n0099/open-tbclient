package com.coloros.mcssdk.c;

import android.util.Log;
/* loaded from: classes3.dex */
public final class c {
    private static String b = "MCS";
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = true;
    private static boolean f = true;
    private static boolean g = true;
    private static String h = "-->";
    private static boolean i = true;

    public static void a(String str) {
        if (e && i) {
            Log.d("com.coloros.mcssdk---", b + h + str);
        }
    }

    public static void b(String str) {
        if (g && i) {
            Log.e("com.coloros.mcssdk---", b + h + str);
        }
    }
}
