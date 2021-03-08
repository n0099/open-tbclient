package com.vivo.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class s implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f8067a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.f8067a = pVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.a aVar;
        com.vivo.push.util.a aVar2;
        if (i == 0) {
            this.f8067a.l = "";
            aVar2 = this.f8067a.k;
            aVar2.a("APP_TOKEN", "");
            this.f8067a.t();
            this.f8067a.k.c("APP_TAGS");
            return;
        }
        this.f8067a.l = null;
        aVar = this.f8067a.k;
        aVar.c("APP_TOKEN");
    }
}
