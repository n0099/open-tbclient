package com.bytedance.sdk.openadsdk.j.e;

import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.err.VAdError;
import java.io.IOException;
/* loaded from: classes4.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.adnet.e.a f7561a;

    public d() {
        this.f7561a = com.bytedance.sdk.openadsdk.i.e.a();
        if (this.f7561a == null) {
            this.f7561a = new j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.j.e.b
    public a a(f fVar) throws IOException, VAdError {
        e eVar = new e(fVar.f7562a, fVar.f7563b);
        if (fVar.c != -1) {
            eVar.setRetryPolicy(new com.bytedance.sdk.adnet.core.g().PT((int) fVar.c));
        }
        return new g(this.f7561a.a(eVar, fVar.e), fVar);
    }
}
