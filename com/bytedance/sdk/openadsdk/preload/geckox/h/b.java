package com.bytedance.sdk.openadsdk.preload.geckox.h;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f30295a = false;

    /* renamed from: b  reason: collision with root package name */
    public static c f30296b = new a();

    public static void a() {
        f30295a = true;
    }

    public static void b(String str, String str2, Throwable th) {
        c cVar;
        if (!f30295a || (cVar = f30296b) == null) {
            return;
        }
        cVar.b(str, str2, th);
    }

    public static void a(String str, Object... objArr) {
        c cVar;
        if (!f30295a || (cVar = f30296b) == null) {
            return;
        }
        cVar.a(str, objArr);
    }

    public static void a(String str, String str2, Throwable th) {
        c cVar;
        if (!f30295a || (cVar = f30296b) == null) {
            return;
        }
        cVar.a(str, str2, th);
    }
}
