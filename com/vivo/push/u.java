package com.vivo.push;

import com.vivo.push.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f13681a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p f13682b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(p pVar, String str) {
        this.f13682b = pVar;
        this.f13681a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a c;
        c = this.f13682b.c(this.f13681a);
        if (c != null) {
            c.a(1003, new Object[0]);
        }
    }
}
