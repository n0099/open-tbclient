package com.xiaomi.push;
/* loaded from: classes18.dex */
public class dq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dq f4865a;

    /* renamed from: a  reason: collision with other field name */
    private dp f229a;

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
    public dp m235a() {
        return this.f229a;
    }

    public void a(dp dpVar) {
        this.f229a = dpVar;
    }
}
