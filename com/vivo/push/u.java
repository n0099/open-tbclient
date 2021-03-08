package com.vivo.push;

import com.vivo.push.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f8072a;
    final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(p pVar, String str) {
        this.b = pVar;
        this.f8072a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a c;
        c = this.b.c(this.f8072a);
        if (c != null) {
            c.a(1003, new Object[0]);
        }
    }
}
