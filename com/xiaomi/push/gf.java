package com.xiaomi.push;
/* loaded from: classes9.dex */
public class gf implements Runnable {
    public final /* synthetic */ gc a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f432a;

    public gf(gc gcVar, String str) {
        this.a = gcVar;
        this.f432a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        cu.a().a(this.f432a, true);
    }
}
