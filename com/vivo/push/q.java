package com.vivo.push;

import com.vivo.push.p;
/* loaded from: classes6.dex */
public final class q implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p.a f37494a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f37495b;

    public q(p pVar, p.a aVar) {
        this.f37495b = pVar;
        this.f37494a = aVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        com.vivo.push.util.a aVar;
        if (i2 == 0) {
            Object[] b2 = this.f37494a.b();
            if (b2 != null && b2.length != 0) {
                this.f37495b.a((String) this.f37494a.b()[0]);
                return;
            } else {
                com.vivo.push.util.p.a("PushClientManager", "bind app result is null");
                return;
            }
        }
        this.f37495b.l = null;
        aVar = this.f37495b.k;
        aVar.c("APP_TOKEN");
    }
}
