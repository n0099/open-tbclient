package com.vivo.push;

import com.vivo.push.p;
/* loaded from: classes7.dex */
public final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39912a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f39913b;

    public u(p pVar, String str) {
        this.f39913b = pVar;
        this.f39912a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a c2;
        c2 = this.f39913b.c(this.f39912a);
        if (c2 != null) {
            c2.a(1003, new Object[0]);
        }
    }
}
