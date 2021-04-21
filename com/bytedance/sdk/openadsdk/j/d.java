package com.bytedance.sdk.openadsdk.j;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f29236a;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str, String str2);

        void a(String str, String str2, Throwable th);
    }

    public static void a(a aVar) {
        f29236a = aVar;
    }

    public static boolean a() {
        return f29236a != null;
    }

    public static void a(String str, String str2) {
        a aVar = f29236a;
        if (aVar == null) {
            return;
        }
        aVar.a(str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        if (f29236a == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        f29236a.a(str, str2, th);
    }
}
