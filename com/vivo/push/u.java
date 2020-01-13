package com.vivo.push;

import com.vivo.push.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class u implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(p pVar, String str) {
        this.b = pVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a c;
        c = this.b.c(this.a);
        if (c != null) {
            c.a(1003, new Object[0]);
        }
    }
}
