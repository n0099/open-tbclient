package com.vivo.push.c;

import com.vivo.push.cache.ClientConfigManagerImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class a extends com.vivo.push.s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.c cVar = (com.vivo.push.b.c) vVar;
        if (!com.vivo.push.m.a().f()) {
            ClientConfigManagerImpl.getInstance(this.a).enablePush();
        }
        com.vivo.push.model.b a = com.vivo.push.util.p.a(this.a);
        if (a == null) {
            com.vivo.push.m.a().a(cVar.h(), 1005, new Object[0]);
            return;
        }
        String a2 = a.a();
        if (a.c()) {
            com.vivo.push.m.a().a(cVar.h(), 1004, new Object[0]);
            vVar = new com.vivo.push.b.e();
        } else {
            int a3 = com.vivo.push.util.o.a(cVar);
            if (a3 != 0) {
                com.vivo.push.m.a().a(cVar.h(), a3, new Object[0]);
                return;
            }
        }
        com.vivo.push.a.a.a(this.a, a2, vVar);
    }
}
