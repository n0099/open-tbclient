package com.vivo.push.c;

import com.vivo.push.cache.ClientConfigManagerImpl;
/* loaded from: classes3.dex */
final class c extends com.vivo.push.v {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.f14008a).isDebug());
    }
}
