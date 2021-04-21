package com.vivo.push;
/* loaded from: classes7.dex */
public final class s implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f39895a;

    public s(p pVar) {
        this.f39895a = pVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.a aVar;
        com.vivo.push.util.a aVar2;
        if (i == 0) {
            this.f39895a.l = "";
            aVar2 = this.f39895a.k;
            aVar2.a("APP_TOKEN", "");
            this.f39895a.t();
            this.f39895a.k.c("APP_TAGS");
            return;
        }
        this.f39895a.l = null;
        aVar = this.f39895a.k;
        aVar.c("APP_TOKEN");
    }
}
