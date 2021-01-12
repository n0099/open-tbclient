package com.vivo.push;

import com.vivo.push.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class q implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p.a f13666a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p f13667b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, p.a aVar) {
        this.f13667b = pVar;
        this.f13666a = aVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.a aVar;
        if (i != 0) {
            this.f13667b.l = null;
            aVar = this.f13667b.k;
            aVar.c("APP_TOKEN");
            return;
        }
        Object[] b2 = this.f13666a.b();
        if (b2 == null || b2.length == 0) {
            com.vivo.push.util.p.a("PushClientManager", "bind app result is null");
        } else {
            this.f13667b.a((String) this.f13666a.b()[0]);
        }
    }
}
