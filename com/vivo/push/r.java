package com.vivo.push;
/* loaded from: classes7.dex */
public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f39797a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f39798b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f39799c;

    public r(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f39799c = pVar;
        this.f39797a = bVar;
        this.f39798b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f39799c.a(this.f39797a);
        this.f39799c.d(this.f39798b);
    }
}
