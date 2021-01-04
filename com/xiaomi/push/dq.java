package com.xiaomi.push;
/* loaded from: classes6.dex */
public class dq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dq f14252a;

    /* renamed from: a  reason: collision with other field name */
    private dp f305a;

    public static dq a() {
        if (f14252a == null) {
            synchronized (dq.class) {
                if (f14252a == null) {
                    f14252a = new dq();
                }
            }
        }
        return f14252a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dp m251a() {
        return this.f305a;
    }

    public void a(dp dpVar) {
        this.f305a = dpVar;
    }
}
