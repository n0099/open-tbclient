package com.vivo.push;

import com.vivo.push.p;
/* loaded from: classes7.dex */
public final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39817a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f39818b;

    public u(p pVar, String str) {
        this.f39818b = pVar;
        this.f39817a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a c2;
        c2 = this.f39818b.c(this.f39817a);
        if (c2 != null) {
            c2.a(1003, new Object[0]);
        }
    }
}
