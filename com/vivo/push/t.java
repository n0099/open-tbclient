package com.vivo.push;
/* loaded from: classes7.dex */
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f39524a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f39525b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f39526c;

    public t(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f39526c = pVar;
        this.f39524a = bVar;
        this.f39525b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f39526c.a(this.f39524a);
        this.f39526c.d(this.f39525b);
    }
}
