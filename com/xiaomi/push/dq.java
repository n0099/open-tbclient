package com.xiaomi.push;
/* loaded from: classes18.dex */
public class dq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dq f4635a;

    /* renamed from: a  reason: collision with other field name */
    private dp f227a;

    public static dq a() {
        if (f4635a == null) {
            synchronized (dq.class) {
                if (f4635a == null) {
                    f4635a = new dq();
                }
            }
        }
        return f4635a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dp m225a() {
        return this.f227a;
    }

    public void a(dp dpVar) {
        this.f227a = dpVar;
    }
}
