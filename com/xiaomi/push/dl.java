package com.xiaomi.push;
/* loaded from: classes5.dex */
public class dl {
    private static volatile dl a;

    /* renamed from: a  reason: collision with other field name */
    private dk f245a;

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
    public dk m209a() {
        return this.f245a;
    }

    public void a(dk dkVar) {
        this.f245a = dkVar;
    }
}
