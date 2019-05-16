package com.vivo.push.c;
/* loaded from: classes3.dex */
final class g extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.util.m.d("OnClearCacheTask", "delete push info " + this.a.getPackageName());
        com.vivo.push.util.v.b(this.a).a();
    }
}
