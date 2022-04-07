package com.meizu.cloud.pushsdk.b.a;

import com.repackage.rm9;
/* loaded from: classes5.dex */
public class a {
    public static boolean a = false;
    public static String b = "AndroidNetworking";

    public static void a() {
        a = true;
    }

    public static void a(String str) {
        if (a) {
            rm9.a(b, str);
        }
    }

    public static void b(String str) {
        if (a) {
            rm9.d(b, str);
        }
    }
}
