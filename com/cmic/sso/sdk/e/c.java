package com.cmic.sso.sdk.e;

import android.util.Log;
/* loaded from: classes7.dex */
public class c {
    private static final c prp = new c();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f8021b = false;

    public static void a(String str, String str2) {
        if (f8021b) {
            Log.e("CMCC-SDK:" + str, "" + str2);
        }
    }

    public static void b(String str, String str2) {
        if (f8021b) {
            Log.d("CMCC-SDK:" + str, "" + str2);
        }
    }

    public static void c(String str, String str2) {
        if (f8021b) {
            Log.i("CMCC-SDK:" + str, "" + str2);
        }
    }
}
