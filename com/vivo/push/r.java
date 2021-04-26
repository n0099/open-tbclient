package com.vivo.push;
/* loaded from: classes6.dex */
public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f37496a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37497b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f37498c;

    public r(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f37498c = pVar;
        this.f37496a = bVar;
        this.f37497b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f37498c.a(this.f37496a);
        this.f37498c.d(this.f37497b);
    }
}
