package com.bytedance.sdk.openadsdk.preload.geckox.h;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f29980a = false;

    /* renamed from: b  reason: collision with root package name */
    public static c f29981b = new a();

    public static void a() {
        f29980a = true;
    }

    public static void b(String str, String str2, Throwable th) {
        c cVar;
        if (!f29980a || (cVar = f29981b) == null) {
            return;
        }
        cVar.b(str, str2, th);
    }

    public static void a(String str, Object... objArr) {
        c cVar;
        if (!f29980a || (cVar = f29981b) == null) {
            return;
        }
        cVar.a(str, objArr);
    }

    public static void a(String str, String str2, Throwable th) {
        c cVar;
        if (!f29980a || (cVar = f29981b) == null) {
            return;
        }
        cVar.a(str, str2, th);
    }
}
