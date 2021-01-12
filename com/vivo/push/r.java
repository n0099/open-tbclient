package com.vivo.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f13668a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f13669b;
    final /* synthetic */ p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, com.vivo.push.b.b bVar, String str) {
        this.c = pVar;
        this.f13668a = bVar;
        this.f13669b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.f13668a);
        this.c.d(this.f13669b);
    }
}
