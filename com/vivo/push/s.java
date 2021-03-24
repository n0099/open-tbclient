package com.vivo.push;
/* loaded from: classes7.dex */
public final class s implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f39510a;

    public s(p pVar) {
        this.f39510a = pVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.a aVar;
        com.vivo.push.util.a aVar2;
        if (i == 0) {
            this.f39510a.l = "";
            aVar2 = this.f39510a.k;
            aVar2.a("APP_TOKEN", "");
            this.f39510a.t();
            this.f39510a.k.c("APP_TAGS");
            return;
        }
        this.f39510a.l = null;
        aVar = this.f39510a.k;
        aVar.c("APP_TOKEN");
    }
}
