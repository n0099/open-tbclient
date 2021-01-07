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
        com.bytedance.tea.crash.c.b hZ = com.bytedance.tea.crash.c.b.hZ(this.f7937b);
        hZ.a(h.esF().a());
        hZ.a(h.esH().a());
        hZ.b(this.pqc.c());
        a2.a(hZ);
        k.a(a2, hZ, this.f7936a);
        return a2;
    }
}
