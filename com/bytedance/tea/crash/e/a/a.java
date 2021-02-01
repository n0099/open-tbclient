package com.bytedance.tea.crash.e.a;

import android.content.Context;
import com.bytedance.tea.crash.g.k;
import com.bytedance.tea.crash.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class a extends c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, b bVar, d dVar) {
        super(com.bytedance.tea.crash.c.ANR, context, bVar, dVar);
    }

    @Override // com.bytedance.tea.crash.e.a.c
    public com.bytedance.tea.crash.c.a a(com.bytedance.tea.crash.c.a aVar) {
        com.bytedance.tea.crash.c.a a2 = super.a(aVar);
        com.bytedance.tea.crash.c.b ia = com.bytedance.tea.crash.c.b.ia(this.f7639b);
        ia.a(h.erd().a());
        ia.a(h.erf().a());
        ia.b(this.pvN.c());
        a2.a(ia);
        a2.a("process_name", com.bytedance.tea.crash.g.a.d(this.f7639b));
        k.a(a2, ia, this.f7638a);
        return a2;
    }
}
