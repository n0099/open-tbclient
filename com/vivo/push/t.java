package com.vivo.push;
/* loaded from: classes7.dex */
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f40366a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40367b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f40368c;

    public t(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f40368c = pVar;
        this.f40366a = bVar;
        this.f40367b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40368c.a(this.f40366a);
        this.f40368c.d(this.f40367b);
    }
}
