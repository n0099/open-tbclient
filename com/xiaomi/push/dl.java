package com.xiaomi.push;
/* loaded from: classes8.dex */
public class dl {
    private static volatile dl a;

    /* renamed from: a  reason: collision with other field name */
    private dk f240a;

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
    public dk m223a() {
        return this.f240a;
    }

    public void a(dk dkVar) {
        this.f240a = dkVar;
    }
}
