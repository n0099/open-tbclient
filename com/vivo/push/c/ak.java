package com.vivo.push.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class ak extends com.vivo.push.v {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        com.vivo.push.b.c cVar = (com.vivo.push.b.c) yVar;
        com.vivo.push.model.b a = com.vivo.push.util.s.a(this.a);
        if (a == null) {
            com.vivo.push.p.a().a(cVar.h(), 1005, new Object[0]);
            return;
        }
        String a2 = a.a();
        if (a.c()) {
            com.vivo.push.p.a().a(cVar.h(), 1004, new Object[0]);
            yVar = new com.vivo.push.b.e();
        } else {
            int a3 = com.vivo.push.util.r.a(cVar);
            if (a3 != 0) {
                com.vivo.push.p.a().a(cVar.h(), a3, new Object[0]);
                return;
            }
        }
        com.vivo.push.a.a.a(this.a, a2, yVar);
    }
}
