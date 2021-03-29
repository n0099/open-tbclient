package com.vivo.push;
/* loaded from: classes7.dex */
public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f39508a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f39509b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f39510c;

    public r(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f39510c = pVar;
        this.f39508a = bVar;
        this.f39509b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f39510c.a(this.f39508a);
        this.f39510c.d(this.f39509b);
    }
}
