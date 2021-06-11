package com.vivo.push;

import com.vivo.push.p;
/* loaded from: classes7.dex */
public final class q implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p.a f40347a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f40348b;

    public q(p pVar, p.a aVar) {
        this.f40348b = pVar;
        this.f40347a = aVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        com.vivo.push.util.a aVar;
        if (i2 == 0) {
            Object[] b2 = this.f40347a.b();
            if (b2 != null && b2.length != 0) {
                this.f40348b.a((String) this.f40347a.b()[0]);
                return;
            } else {
                com.vivo.push.util.p.a("PushClientManager", "bind app result is null");
                return;
            }
        }
        this.f40348b.l = null;
        aVar = this.f40348b.k;
        aVar.c("APP_TOKEN");
    }
}
