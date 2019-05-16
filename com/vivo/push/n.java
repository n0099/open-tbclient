package com.vivo.push;

import com.vivo.push.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class n implements IPushActionListener {
    final /* synthetic */ m.a a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, m.a aVar) {
        this.b = mVar;
        this.a = aVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.a aVar;
        com.vivo.push.util.a aVar2;
        String str;
        if (i != 0) {
            this.b.l = null;
            aVar = this.b.k;
            aVar.c("APP_TOKEN");
            return;
        }
        Object[] b = this.a.b();
        if (b == null || b.length == 0) {
            com.vivo.push.util.m.a("PushClientManager", "bind app result is null");
            return;
        }
        this.b.l = (String) this.a.b()[0];
        aVar2 = this.b.k;
        str = this.b.l;
        aVar2.a("APP_TOKEN", str);
    }
}
