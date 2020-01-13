package com.vivo.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class s implements IPushActionListener {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.a = pVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.a aVar;
        com.vivo.push.util.a aVar2;
        if (i == 0) {
            this.a.l = "";
            aVar2 = this.a.k;
            aVar2.a("APP_TOKEN", "");
            this.a.u();
            this.a.k.c("APP_TAGS");
            return;
        }
        this.a.l = null;
        aVar = this.a.k;
        aVar.c("APP_TOKEN");
    }
}
