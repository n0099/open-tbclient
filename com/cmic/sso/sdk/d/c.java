package com.cmic.sso.sdk.d;

import android.util.Log;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f30740a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f30741b = false;

    public static void a(boolean z) {
        f30741b = z;
    }

    public static void b(String str, String str2) {
        if (f30741b) {
            Log.d("CMCC-SDK:" + str, "" + str2);
        }
    }

    public static void a(String str, String str2) {
        if (f30741b) {
            Log.e("CMCC-SDK:" + str, "" + str2);
        }
    }
}
