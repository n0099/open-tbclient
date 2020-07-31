package com.xiaomi.push;
/* loaded from: classes9.dex */
public class dq {
    private static volatile dq a;

    /* renamed from: a  reason: collision with other field name */
    private dp f228a;

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
    public dp m227a() {
        return this.f228a;
    }

    public void a(dp dpVar) {
        this.f228a = dpVar;
    }
}
