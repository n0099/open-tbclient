package com.bytedance.sdk.openadsdk.i.e;

import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.err.VAdError;
import java.io.IOException;
/* loaded from: classes6.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.adnet.e.a f4829a;

    public d() {
        this.f4829a = com.bytedance.sdk.openadsdk.h.d.a();
        if (this.f4829a == null) {
            this.f4829a = new l();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.e.b
    public a a(f fVar) throws IOException, VAdError {
        e eVar = new e(fVar.f4830a, fVar.b);
        if (fVar.c != -1) {
            eVar.setRetryPolicy(new com.bytedance.sdk.adnet.core.g().OM((int) fVar.c));
        }
        return new g(this.f4829a.a(eVar, fVar.e), fVar);
    }
}
