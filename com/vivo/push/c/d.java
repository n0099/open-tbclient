package com.vivo.push.c;
/* loaded from: classes3.dex */
final class d extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.j jVar = (com.vivo.push.b.j) vVar;
        String e = jVar.e();
        com.vivo.push.m.a().a(jVar.g(), jVar.h(), e);
        b.post(new e(this, e, jVar));
    }
}
