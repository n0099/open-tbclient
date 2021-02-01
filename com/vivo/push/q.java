package com.vivo.push;

import com.vivo.push.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class q implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p.a f13668a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p f13669b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, p.a aVar) {
        this.f13669b = pVar;
        this.f13668a = aVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.a aVar;
        if (i != 0) {
            this.f13669b.l = null;
            aVar = this.f13669b.k;
            aVar.c("APP_TOKEN");
            return;
        }
        Object[] b2 = this.f13668a.b();
        if (b2 == null || b2.length == 0) {
            com.vivo.push.util.p.a("PushClientManager", "bind app result is null");
        } else {
            this.f13669b.a((String) this.f13668a.b()[0]);
        }
    }
}
