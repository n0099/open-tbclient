package com.vivo.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class s implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f13969a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.f13969a = pVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.a aVar;
        com.vivo.push.util.a aVar2;
        if (i == 0) {
            this.f13969a.l = "";
            aVar2 = this.f13969a.k;
            aVar2.a("APP_TOKEN", "");
            this.f13969a.t();
            this.f13969a.k.c("APP_TAGS");
            return;
        }
        this.f13969a.l = null;
        aVar = this.f13969a.k;
        aVar.c("APP_TOKEN");
    }
}
