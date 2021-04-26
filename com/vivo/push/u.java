package com.vivo.push;

import com.vivo.push.p;
/* loaded from: classes6.dex */
public final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37516a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f37517b;

    public u(p pVar, String str) {
        this.f37517b = pVar;
        this.f37516a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a c2;
        c2 = this.f37517b.c(this.f37516a);
        if (c2 != null) {
            c2.a(1003, new Object[0]);
        }
    }
}
