package com.xiaomi.push;
/* loaded from: classes10.dex */
public class dm {
    public static volatile dm a;

    /* renamed from: a  reason: collision with other field name */
    public dl f232a;

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
    public dl m363a() {
        return this.f232a;
    }

    public void a(dl dlVar) {
        this.f232a = dlVar;
    }
}
