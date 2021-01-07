package com.xiaomi.push;
/* loaded from: classes6.dex */
public class dq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dq f14253a;

    /* renamed from: a  reason: collision with other field name */
    private dp f306a;

    public static dq a() {
        if (f14253a == null) {
            synchronized (dq.class) {
                if (f14253a == null) {
                    f14253a = new dq();
                }
            }
        }
        return f14253a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dp m262a() {
        return this.f306a;
    }

    public void a(dp dpVar) {
        this.f306a = dpVar;
    }
}
