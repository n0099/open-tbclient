package com.vivo.push;

import com.vivo.push.p;
/* loaded from: classes7.dex */
public final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39527a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f39528b;

    public u(p pVar, String str) {
        this.f39528b = pVar;
        this.f39527a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a c2;
        c2 = this.f39528b.c(this.f39527a);
        if (c2 != null) {
            c2.a(1003, new Object[0]);
        }
    }
}
