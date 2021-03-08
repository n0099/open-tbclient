package com.xiaomi.push;
/* loaded from: classes5.dex */
public class dq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dq f8328a;

    /* renamed from: a  reason: collision with other field name */
    private dp f226a;

    public static dq a() {
        if (f8328a == null) {
            synchronized (dq.class) {
                if (f8328a == null) {
                    f8328a = new dq();
                }
            }
        }
        return f8328a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dp m236a() {
        return this.f226a;
    }

    public void a(dp dpVar) {
        this.f226a = dpVar;
    }
}
