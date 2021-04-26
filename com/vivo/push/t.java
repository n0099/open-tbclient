package com.vivo.push;
/* loaded from: classes6.dex */
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f37513a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37514b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f37515c;

    public t(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f37515c = pVar;
        this.f37513a = bVar;
        this.f37514b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f37515c.a(this.f37513a);
        this.f37515c.d(this.f37514b);
    }
}
