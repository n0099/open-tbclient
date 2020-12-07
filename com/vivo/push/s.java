package com.vivo.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class s implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f4462a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.f4462a = pVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.a aVar;
        com.vivo.push.util.a aVar2;
        if (i == 0) {
            this.f4462a.l = "";
            aVar2 = this.f4462a.k;
            aVar2.a("APP_TOKEN", "");
            this.f4462a.t();
            this.f4462a.k.c("APP_TAGS");
            return;
        }
        this.f4462a.l = null;
        aVar = this.f4462a.k;
        aVar.c("APP_TOKEN");
    }
}
