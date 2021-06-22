package com.vivo.push;
/* loaded from: classes7.dex */
public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f40452a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40453b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f40454c;

    public r(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f40454c = pVar;
        this.f40452a = bVar;
        this.f40453b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40454c.a(this.f40452a);
        this.f40454c.d(this.f40453b);
    }
}
