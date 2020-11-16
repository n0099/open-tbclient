package com.vivo.push.c;

import android.text.TextUtils;
/* loaded from: classes11.dex */
final class d extends ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    protected final void a(com.vivo.push.y yVar) {
        com.vivo.push.b.k kVar = (com.vivo.push.b.k) yVar;
        String e = kVar.e();
        com.vivo.push.p.a().a(kVar.g(), kVar.h(), e);
        if (TextUtils.isEmpty(kVar.g()) && !TextUtils.isEmpty(e)) {
            com.vivo.push.p.a().a(e);
        }
        com.vivo.push.w.b(new e(this, e, kVar));
    }
}
