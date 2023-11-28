package com.xiaomi.push;
/* loaded from: classes10.dex */
public class gf implements Runnable {
    public final /* synthetic */ gc a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f428a;

    public gf(gc gcVar, String str) {
        this.a = gcVar;
        this.f428a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cu.a().a(this.f428a, true);
    }
}
