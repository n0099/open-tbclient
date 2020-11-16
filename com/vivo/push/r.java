package com.vivo.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f4691a;
    final /* synthetic */ String b;
    final /* synthetic */ p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, com.vivo.push.b.b bVar, String str) {
        this.c = pVar;
        this.f4691a = bVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.f4691a);
        this.c.d(this.b);
    }
}
