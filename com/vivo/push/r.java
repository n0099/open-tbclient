package com.vivo.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f13670a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f13671b;
    final /* synthetic */ p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, com.vivo.push.b.b bVar, String str) {
        this.c = pVar;
        this.f13670a = bVar;
        this.f13671b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.f13670a);
        this.c.d(this.f13671b);
    }
}
