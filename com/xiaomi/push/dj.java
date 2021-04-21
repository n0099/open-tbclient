package com.xiaomi.push;
/* loaded from: classes7.dex */
public class dj {

    /* renamed from: a  reason: collision with root package name */
    public static volatile dj f40749a;

    /* renamed from: a  reason: collision with other field name */
    public di f235a;

    public static dj a() {
        if (f40749a == null) {
            synchronized (dj.class) {
                if (f40749a == null) {
                    f40749a = new dj();
                }
            }
        }
        return f40749a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public di m231a() {
        return this.f235a;
    }

    public void a(di diVar) {
        this.f235a = diVar;
    }
}
