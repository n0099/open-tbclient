package com.vivo.push;

import com.vivo.push.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f13679a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p f13680b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(p pVar, String str) {
        this.f13680b = pVar;
        this.f13679a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a c;
        c = this.f13680b.c(this.f13679a);
        if (c != null) {
            c.a(1003, new Object[0]);
        }
    }
}
