package com.vivo.push;
/* loaded from: classes7.dex */
public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f39892a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f39893b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f39894c;

    public r(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f39894c = pVar;
        this.f39892a = bVar;
        this.f39893b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f39894c.a(this.f39892a);
        this.f39894c.d(this.f39893b);
    }
}
