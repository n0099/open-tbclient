package com.bytedance.sdk.openadsdk.preload.geckox.h;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7489a = false;

    /* renamed from: b  reason: collision with root package name */
    private static c f7490b = new a();

    public static void a() {
        f7489a = true;
    }

    public static void a(String str, Object... objArr) {
        if (f7489a && f7490b != null) {
            f7490b.a(str, objArr);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f7489a && f7490b != null) {
            f7490b.a(str, str2, th);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f7489a && f7490b != null) {
            f7490b.b(str, str2, th);
        }
    }
}
