package com.meizu.cloud.pushsdk.b.a;
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4078a = false;
    private static String b = "AndroidNetworking";

    public static void a() {
        f4078a = true;
    }

    public static void a(String str) {
        if (f4078a) {
            com.meizu.cloud.a.a.d(b, str);
        }
    }

    public static void b(String str) {
        if (f4078a) {
            com.meizu.cloud.a.a.i(b, str);
        }
    }
}
