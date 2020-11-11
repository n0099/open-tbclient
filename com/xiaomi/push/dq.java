package com.xiaomi.push;
/* loaded from: classes12.dex */
public class dq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dq f4865a;

    /* renamed from: a  reason: collision with other field name */
    private dp f226a;

    public static dq a() {
        if (f4865a == null) {
            synchronized (dq.class) {
                if (f4865a == null) {
                    f4865a = new dq();
                }
            }
        }
        return f4865a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dp m232a() {
        return this.f226a;
    }

    public void a(dp dpVar) {
        this.f226a = dpVar;
    }
}
