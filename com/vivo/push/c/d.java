package com.vivo.push.c;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public final class d extends ab {
    public d(com.vivo.push.y yVar) {
        super(yVar);
    }

    @Override // com.vivo.push.v
    public final void a(com.vivo.push.y yVar) {
        com.vivo.push.b.k kVar = (com.vivo.push.b.k) yVar;
        String e2 = kVar.e();
        com.vivo.push.p.a().a(kVar.g(), kVar.h(), e2);
        if (TextUtils.isEmpty(kVar.g()) && !TextUtils.isEmpty(e2)) {
            com.vivo.push.p.a().a(e2);
        }
        com.vivo.push.w.b(new e(this, e2, kVar));
    }
}
