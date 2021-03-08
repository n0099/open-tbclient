package com.meizu.cloud.pushsdk.b.a;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7322a = false;
    private static String b = "AndroidNetworking";

    public static void a() {
        f7322a = true;
    }

    public static void a(String str) {
        if (f7322a) {
            com.meizu.cloud.a.a.d(b, str);
        }
    }

    public static void b(String str) {
        if (f7322a) {
            com.meizu.cloud.a.a.i(b, str);
        }
    }
}
