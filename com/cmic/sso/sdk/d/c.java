package com.cmic.sso.sdk.d;

import android.util.Log;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f30462a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f30463b = false;

    public static void a(boolean z) {
        f30463b = z;
    }

    public static void b(String str, String str2) {
        if (f30463b) {
            Log.d("CMCC-SDK:" + str, "" + str2);
        }
    }

    public static void c(String str, String str2) {
        if (f30463b) {
            Log.i("CMCC-SDK:" + str, "" + str2);
        }
    }

    public static void a(String str, String str2) {
        if (f30463b) {
            Log.e("CMCC-SDK:" + str, "" + str2);
        }
    }
}
