package com.vivo.push;
/* loaded from: classes7.dex */
public final class s implements IPushActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f40352a;

    public s(p pVar) {
        this.f40352a = pVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        com.vivo.push.util.a aVar;
        com.vivo.push.util.a aVar2;
        if (i2 == 0) {
            this.f40352a.l = "";
            aVar2 = this.f40352a.k;
            aVar2.a("APP_TOKEN", "");
            this.f40352a.t();
            this.f40352a.k.c("APP_TAGS");
            return;
        }
        this.f40352a.l = null;
        aVar = this.f40352a.k;
        aVar.c("APP_TOKEN");
    }
}
