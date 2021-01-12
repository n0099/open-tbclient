package com.bytedance.tea.crash.e.a;

import android.content.Context;
import com.bytedance.tea.crash.g.k;
import com.bytedance.tea.crash.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class g extends c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Context context, b bVar, d dVar) {
        super(com.bytedance.tea.crash.c.JAVA, context, bVar, dVar);
    }

    @Override // com.bytedance.tea.crash.e.a.c
    public com.bytedance.tea.crash.c.a a(com.bytedance.tea.crash.c.a aVar) {
        com.bytedance.tea.crash.c.a a2 = super.a(aVar);
        a2.a("app_count", 1);
        a2.a("magic_tag", "ss_app_log");
        c(a2);
        com.bytedance.tea.crash.c.b hX = com.bytedance.tea.crash.c.b.hX(this.f7637b);
        hX.a(h.eoL().a());
        hX.a(h.eoN().a());
        hX.b(this.plx.c());
        a2.a(hX);
        k.a(a2, hX, this.f7636a);
        return a2;
    }
}
