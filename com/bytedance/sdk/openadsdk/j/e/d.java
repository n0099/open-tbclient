package com.bytedance.sdk.openadsdk.j.e;

import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.err.VAdError;
import java.io.IOException;
/* loaded from: classes4.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.adnet.e.a f7261a;

    public d() {
        this.f7261a = com.bytedance.sdk.openadsdk.i.e.a();
        if (this.f7261a == null) {
            this.f7261a = new j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.j.e.b
    public a a(f fVar) throws IOException, VAdError {
        e eVar = new e(fVar.f7262a, fVar.f7263b);
        if (fVar.c != -1) {
            eVar.setRetryPolicy(new com.bytedance.sdk.adnet.core.g().Om((int) fVar.c));
        }
        return new g(this.f7261a.a(eVar, fVar.e), fVar);
    }
}
