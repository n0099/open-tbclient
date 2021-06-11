package com.vivo.push;
/* loaded from: classes7.dex */
public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f40349a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40350b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f40351c;

    public r(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f40351c = pVar;
        this.f40349a = bVar;
        this.f40350b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40351c.a(this.f40349a);
        this.f40351c.d(this.f40350b);
    }
}
