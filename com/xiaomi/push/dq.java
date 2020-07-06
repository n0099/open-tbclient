package com.xiaomi.push;
/* loaded from: classes8.dex */
public class dq {
    private static volatile dq a;

    /* renamed from: a  reason: collision with other field name */
    private dp f232a;

    public static dq a() {
        if (a == null) {
            synchronized (dq.class) {
                if (a == null) {
                    a = new dq();
                }
            }
        }
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dp m226a() {
        return this.f232a;
    }

    public void a(dp dpVar) {
        this.f232a = dpVar;
    }
}
