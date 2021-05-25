package com.vivo.push;
/* loaded from: classes7.dex */
public final class s implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f36673a;

    public s(p pVar) {
        this.f36673a = pVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        com.vivo.push.util.a aVar;
        com.vivo.push.util.a aVar2;
        if (i2 == 0) {
            this.f36673a.l = "";
            aVar2 = this.f36673a.k;
            aVar2.a("APP_TOKEN", "");
            this.f36673a.t();
            this.f36673a.k.c("APP_TAGS");
            return;
        }
        this.f36673a.l = null;
        aVar = this.f36673a.k;
        aVar.c("APP_TOKEN");
    }
}
