package com.vivo.push.c;
/* loaded from: classes4.dex */
final class g extends ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        com.vivo.push.util.p.d("OnClearCacheTask", "delete push info " + this.f14009a.getPackageName());
        com.vivo.push.util.y.b(this.f14009a).a();
    }
}
