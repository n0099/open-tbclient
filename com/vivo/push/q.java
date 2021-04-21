package com.vivo.push;

import com.vivo.push.p;
/* loaded from: classes7.dex */
public final class q implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p.a f39890a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f39891b;

    public q(p pVar, p.a aVar) {
        this.f39891b = pVar;
        this.f39890a = aVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.a aVar;
        if (i == 0) {
            Object[] b2 = this.f39890a.b();
            if (b2 != null && b2.length != 0) {
                this.f39891b.a((String) this.f39890a.b()[0]);
                return;
            } else {
                com.vivo.push.util.p.a("PushClientManager", "bind app result is null");
                return;
            }
        }
        this.f39891b.l = null;
        aVar = this.f39891b.k;
        aVar.c("APP_TOKEN");
    }
}
