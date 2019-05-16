package com.vivo.push.c;

import com.vivo.push.cache.ClientConfigManagerImpl;
/* loaded from: classes3.dex */
final class c extends com.vivo.push.s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.util.m.a(ClientConfigManagerImpl.getInstance(this.a).isDebug());
    }
}
