package com.vivo.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f4466a;
    final /* synthetic */ String b;
    final /* synthetic */ p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, com.vivo.push.b.b bVar, String str) {
        this.c = pVar;
        this.f4466a = bVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.f4466a);
        this.c.d(this.b);
    }
}
