package com.vivo.push;

import com.vivo.push.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class q implements IPushActionListener {
    final /* synthetic */ p.a a;
    final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, p.a aVar) {
        this.b = pVar;
        this.a = aVar;
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
        Object[] b = this.a.b();
        if (b == null || b.length == 0) {
            com.vivo.push.util.p.a("PushClientManager", "bind app result is null");
        } else {
            this.b.a((String) this.a.b()[0]);
        }
    }
}
