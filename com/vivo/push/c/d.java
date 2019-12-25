package com.vivo.push.c;

import android.text.TextUtils;
/* loaded from: classes5.dex */
final class d extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        com.vivo.push.b.j jVar = (com.vivo.push.b.j) yVar;
        String e = jVar.e();
        com.vivo.push.p.a().a(jVar.g(), jVar.h(), e);
        if (TextUtils.isEmpty(jVar.g()) && !TextUtils.isEmpty(e)) {
            com.vivo.push.p.a().a(e);
        }
        com.vivo.push.w.b(new e(this, e, jVar));
    }
}
