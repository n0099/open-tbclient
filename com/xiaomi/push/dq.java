package com.xiaomi.push;
/* loaded from: classes6.dex */
public class dq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dq f13955a;

    /* renamed from: a  reason: collision with other field name */
    private dp f305a;

    public static dq a() {
        if (f13955a == null) {
            synchronized (dq.class) {
                if (f13955a == null) {
                    f13955a = new dq();
                }
            }
        }
        return f13955a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dp m258a() {
        return this.f305a;
    }

    public void a(dp dpVar) {
        this.f305a = dpVar;
    }
}
