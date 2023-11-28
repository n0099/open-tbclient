package com.xiaomi.push;
/* loaded from: classes10.dex */
public class dm {
    public static volatile dm a;

    /* renamed from: a  reason: collision with other field name */
    public dl f227a;

    public static dm a() {
        if (a == null) {
            synchronized (dm.class) {
                if (a == null) {
                    a = new dm();
                }
            }
        }
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dl m373a() {
        return this.f227a;
    }

    public void a(dl dlVar) {
        this.f227a = dlVar;
    }
}
