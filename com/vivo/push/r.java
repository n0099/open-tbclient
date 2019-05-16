package com.vivo.push;

import com.vivo.push.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class r implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(m mVar, String str) {
        this.b = mVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.a b;
        b = this.b.b(this.a);
        if (b != null) {
            b.a(1003, new Object[0]);
        }
    }
}
