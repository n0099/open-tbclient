package com.vivo.push;
/* loaded from: classes7.dex */
public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f36670a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f36671b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f36672c;

    public r(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f36672c = pVar;
        this.f36670a = bVar;
        this.f36671b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36672c.a(this.f36670a);
        this.f36672c.d(this.f36671b);
    }
}
