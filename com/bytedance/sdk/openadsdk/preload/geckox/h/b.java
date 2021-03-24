package com.bytedance.sdk.openadsdk.preload.geckox.h;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f30294a = false;

    /* renamed from: b  reason: collision with root package name */
    public static c f30295b = new a();

    public static void a() {
        f30294a = true;
    }

    public static void b(String str, String str2, Throwable th) {
        c cVar;
        if (!f30294a || (cVar = f30295b) == null) {
            return;
        }
        cVar.b(str, str2, th);
    }

    public static void a(String str, Object... objArr) {
        c cVar;
        if (!f30294a || (cVar = f30295b) == null) {
            return;
        }
        cVar.a(str, objArr);
    }

    public static void a(String str, String str2, Throwable th) {
        c cVar;
        if (!f30294a || (cVar = f30295b) == null) {
            return;
        }
        cVar.a(str, str2, th);
    }
}
