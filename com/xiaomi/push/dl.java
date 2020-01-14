package com.xiaomi.push;
/* loaded from: classes6.dex */
public class dl {
    private static volatile dl a;

    /* renamed from: a  reason: collision with other field name */
    private dk f244a;

    public static dl a() {
        if (a == null) {
            synchronized (dl.class) {
                if (a == null) {
                    a = new dl();
                }
            }
        }
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dk m218a() {
        return this.f244a;
    }

    public void a(dk dkVar) {
        this.f244a = dkVar;
    }
}
