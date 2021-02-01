package com.vivo.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class s implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f13672a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.f13672a = pVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.a aVar;
        com.vivo.push.util.a aVar2;
        if (i == 0) {
            this.f13672a.l = "";
            aVar2 = this.f13672a.k;
            aVar2.a("APP_TOKEN", "");
            this.f13672a.t();
            this.f13672a.k.c("APP_TAGS");
            return;
        }
        this.f13672a.l = null;
        aVar = this.f13672a.k;
        aVar.c("APP_TOKEN");
    }
}
