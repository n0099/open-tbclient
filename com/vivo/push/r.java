package com.vivo.push;
/* loaded from: classes7.dex */
public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f39507a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f39508b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f39509c;

    public r(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f39509c = pVar;
        this.f39507a = bVar;
        this.f39508b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f39509c.a(this.f39507a);
        this.f39509c.d(this.f39508b);
    }
}
