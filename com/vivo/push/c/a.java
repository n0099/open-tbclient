package com.vivo.push.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class a extends com.vivo.push.v {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        com.vivo.push.b.c cVar = (com.vivo.push.b.c) yVar;
        com.vivo.push.model.b a2 = com.vivo.push.util.s.a(this.f4712a);
        if (a2 == null) {
            com.vivo.push.p.a().a(cVar.h(), 1005, new Object[0]);
            return;
        }
        String a3 = a2.a();
        if (a2.c()) {
            com.vivo.push.p.a().a(cVar.h(), 1004, new Object[0]);
            yVar = new com.vivo.push.b.e();
        } else {
            int a4 = com.vivo.push.util.r.a(cVar);
            if (a4 != 0) {
                com.vivo.push.p.a().a(cVar.h(), a4, new Object[0]);
                return;
            }
        }
        com.vivo.push.a.a.a(this.f4712a, a3, yVar);
    }
}
