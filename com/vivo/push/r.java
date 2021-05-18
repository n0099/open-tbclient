package com.vivo.push;
/* loaded from: classes7.dex */
public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f36741a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f36742b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f36743c;

    public r(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f36743c = pVar;
        this.f36741a = bVar;
        this.f36742b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36743c.a(this.f36741a);
        this.f36743c.d(this.f36742b);
    }
}
