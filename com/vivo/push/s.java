package com.vivo.push;
/* loaded from: classes7.dex */
public final class s implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f39800a;

    public s(p pVar) {
        this.f39800a = pVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.a aVar;
        com.vivo.push.util.a aVar2;
        if (i == 0) {
            this.f39800a.l = "";
            aVar2 = this.f39800a.k;
            aVar2.a("APP_TOKEN", "");
            this.f39800a.t();
            this.f39800a.k.c("APP_TAGS");
            return;
        }
        this.f39800a.l = null;
        aVar = this.f39800a.k;
        aVar.c("APP_TOKEN");
    }
}
