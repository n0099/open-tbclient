package com.bytedance.sdk.openadsdk.j;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f29377a;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, String str2);

        void a(String str, String str2, Throwable th);
    }

    public static void a(a aVar) {
        f29377a = aVar;
    }

    public static boolean a() {
        return f29377a != null;
    }

    public static void a(String str, String str2) {
        a aVar = f29377a;
        if (aVar == null) {
            return;
        }
        aVar.a(str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        if (f29377a == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        f29377a.a(str, str2, th);
    }
}
