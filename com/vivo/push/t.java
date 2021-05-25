package com.vivo.push;
/* loaded from: classes7.dex */
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f36687a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f36688b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f36689c;

    public t(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f36689c = pVar;
        this.f36687a = bVar;
        this.f36688b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36689c.a(this.f36687a);
        this.f36689c.d(this.f36688b);
    }
}
