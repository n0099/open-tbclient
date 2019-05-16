package com.vivo.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ com.vivo.push.b.b a;
    final /* synthetic */ String b;
    final /* synthetic */ m c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar, com.vivo.push.b.b bVar, String str) {
        this.c = mVar;
        this.a = bVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.a);
        this.c.c(this.b);
    }
}
