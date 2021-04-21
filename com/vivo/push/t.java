package com.vivo.push;
/* loaded from: classes7.dex */
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f39909a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f39910b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f39911c;

    public t(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f39911c = pVar;
        this.f39909a = bVar;
        this.f39910b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f39911c.a(this.f39909a);
        this.f39911c.d(this.f39910b);
    }
}
