package com.bytedance.sdk.openadsdk.preload.geckox.h;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7491a = false;

    /* renamed from: b  reason: collision with root package name */
    private static c f7492b = new a();

    public static void a() {
        f7491a = true;
    }

    public static void a(String str, Object... objArr) {
        if (f7491a && f7492b != null) {
            f7492b.a(str, objArr);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f7491a && f7492b != null) {
            f7492b.a(str, str2, th);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f7491a && f7492b != null) {
            f7492b.b(str, str2, th);
        }
    }
}
