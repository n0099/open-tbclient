package com.vivo.push;

import com.vivo.push.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4697a;
    final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(p pVar, String str) {
        this.b = pVar;
        this.f4697a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a c;
        c = this.b.c(this.f4697a);
        if (c != null) {
            c.a(1003, new Object[0]);
        }
    }
}
