package com.vivo.push;

import com.vivo.push.p;
/* loaded from: classes7.dex */
public final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f40472a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f40473b;

    public u(p pVar, String str) {
        this.f40473b = pVar;
        this.f40472a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a c2;
        c2 = this.f40473b.c(this.f40472a);
        if (c2 != null) {
            c2.a(1003, new Object[0]);
        }
    }
}
