package com.vivo.push;
/* loaded from: classes7.dex */
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f36758a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f36759b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f36760c;

    public t(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f36760c = pVar;
        this.f36758a = bVar;
        this.f36759b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36760c.a(this.f36758a);
        this.f36760c.d(this.f36759b);
    }
}
