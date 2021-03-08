package com.bytedance.sdk.openadsdk.preload.geckox.h;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f5082a = false;
    private static c b = new a();

    public static void a() {
        f5082a = true;
    }

    public static void a(String str, Object... objArr) {
        if (f5082a && b != null) {
            b.a(str, objArr);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f5082a && b != null) {
            b.a(str, str2, th);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f5082a && b != null) {
            b.b(str, str2, th);
        }
    }
}
