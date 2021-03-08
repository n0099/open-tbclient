package com.vivo.push;

import com.vivo.push.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class q implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p.a f8065a;
    final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, p.a aVar) {
        this.b = pVar;
        this.f8065a = aVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.a aVar;
        if (i != 0) {
            this.b.l = null;
            aVar = this.b.k;
            aVar.c("APP_TOKEN");
            return;
        }
        Object[] b = this.f8065a.b();
        if (b == null || b.length == 0) {
            com.vivo.push.util.p.a("PushClientManager", "bind app result is null");
        } else {
            this.b.a((String) this.f8065a.b()[0]);
        }
    }
}
