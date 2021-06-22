package com.vivo.push;
/* loaded from: classes7.dex */
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f40469a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40470b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f40471c;

    public t(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f40471c = pVar;
        this.f40469a = bVar;
        this.f40470b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40471c.a(this.f40469a);
        this.f40471c.d(this.f40470b);
    }
}
