package com.vivo.push.c;

import com.vivo.push.cache.ClientConfigManagerImpl;
/* loaded from: classes7.dex */
public final class c extends com.vivo.push.v {
    public c(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    public final void a(com.vivo.push.y yVar) {
        com.vivo.push.util.p.a(ClientConfigManagerImpl.getInstance(this.f39878a).isDebug());
    }
}
