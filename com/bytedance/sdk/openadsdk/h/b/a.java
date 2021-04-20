package com.bytedance.sdk.openadsdk.h.b;

import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.l.a.b;
import com.bytedance.sdk.openadsdk.l.c;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes5.dex */
public class a implements c {
    @Override // com.bytedance.sdk.openadsdk.l.c
    public void a(com.bytedance.sdk.openadsdk.l.a.c cVar) {
        if (cVar == null || cVar.a() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.h.a.c b2 = com.bytedance.sdk.openadsdk.h.a.c.b().a("tt_pangle_thread_pool").b(cVar.a().toString());
        p.i().a(b2, false);
        u.c("ReportThreadLogServiceI", "execReportThreadPoolLog: " + b2.a());
    }

    @Override // com.bytedance.sdk.openadsdk.l.c
    public void a(b bVar) {
        if (bVar == null || bVar.a() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.h.a.c b2 = com.bytedance.sdk.openadsdk.h.a.c.b().a("tt_pangle_sdk_thread_state").b(bVar.a().toString());
        p.i().a(b2, false);
        u.c("ReportThreadLogServiceI", "execReportSdkThreadLog: " + b2.a());
    }
}
