package com.bytedance.sdk.openadsdk.playable;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static a f4949a;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, String str2);

        void a(String str, String str2, Throwable th);
    }

    public static void a(a aVar) {
        f4949a = aVar;
    }

    public static boolean a() {
        return f4949a != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str, String str2) {
        if (f4949a != null) {
            f4949a.a(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str, String str2, Throwable th) {
        if (f4949a != null) {
            if (th == null) {
                th = new Throwable();
            }
            f4949a.a(str, str2, th);
        }
    }
}
