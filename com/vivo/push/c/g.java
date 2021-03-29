package com.vivo.push.c;
/* loaded from: classes7.dex */
public final class g extends ab {
    public g(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    public final void a(com.vivo.push.y yVar) {
        com.vivo.push.util.p.d("OnClearCacheTask", "delete push info " + this.f39589a.getPackageName());
        com.vivo.push.util.y.b(this.f39589a).a();
    }
}
