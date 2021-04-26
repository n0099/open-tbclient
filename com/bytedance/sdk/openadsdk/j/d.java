package com.bytedance.sdk.openadsdk.j;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f30132a;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, String str2);

        void a(String str, String str2, Throwable th);
    }

    public static void a(a aVar) {
        f30132a = aVar;
    }

    public static boolean a() {
        return f30132a != null;
    }

    public static void a(String str, String str2) {
        a aVar = f30132a;
        if (aVar == null) {
            return;
        }
        aVar.a(str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        if (f30132a == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        f30132a.a(str, str2, th);
    }
}
