package com.xiaomi.push;
/* loaded from: classes12.dex */
public class dq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dq f4863a;

    /* renamed from: a  reason: collision with other field name */
    private dp f224a;

    public static dq a() {
        if (f4863a == null) {
            synchronized (dq.class) {
                if (f4863a == null) {
                    f4863a = new dq();
                }
            }
        }
        return f4863a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dp m232a() {
        return this.f224a;
    }

    public void a(dp dpVar) {
        this.f224a = dpVar;
    }
}
