package com.vivo.push.c;
/* loaded from: classes3.dex */
final class ae extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.j jVar = (com.vivo.push.b.j) vVar;
        com.vivo.push.m.a().a(jVar.g(), jVar.h(), new Object[0]);
        b.post(new af(this, jVar));
    }
}
