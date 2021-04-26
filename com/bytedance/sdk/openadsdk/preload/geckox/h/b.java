package com.bytedance.sdk.openadsdk.preload.geckox.h;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f30904a = false;

    /* renamed from: b  reason: collision with root package name */
    public static c f30905b = new a();

    public static void a() {
        f30904a = true;
    }

    public static void b(String str, String str2, Throwable th) {
        c cVar;
        if (!f30904a || (cVar = f30905b) == null) {
            return;
        }
        cVar.b(str, str2, th);
    }

    public static void a(String str, Object... objArr) {
        c cVar;
        if (!f30904a || (cVar = f30905b) == null) {
            return;
        }
        cVar.a(str, objArr);
    }

    public static void a(String str, String str2, Throwable th) {
        c cVar;
        if (!f30904a || (cVar = f30905b) == null) {
            return;
        }
        cVar.a(str, str2, th);
    }
}
