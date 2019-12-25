package com.vivo.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class t implements Runnable {
    final /* synthetic */ com.vivo.push.b.b a;
    final /* synthetic */ String b;
    final /* synthetic */ p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, com.vivo.push.b.b bVar, String str) {
        this.c = pVar;
        this.a = bVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.a);
        this.c.d(this.b);
    }
}
