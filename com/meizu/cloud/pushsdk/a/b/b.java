package com.meizu.cloud.pushsdk.a.b;
/* loaded from: classes2.dex */
public class b {
    private static b a = null;
    private final d b = new c();

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public d b() {
        return this.b;
    }
}
