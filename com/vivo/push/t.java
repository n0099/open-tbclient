package com.vivo.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f13976a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f13977b;
    final /* synthetic */ p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, com.vivo.push.b.b bVar, String str) {
        this.c = pVar;
        this.f13976a = bVar;
        this.f13977b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.f13976a);
        this.c.d(this.f13977b);
    }
}
