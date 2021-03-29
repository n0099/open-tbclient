package com.bytedance.sdk.openadsdk.k.e;

import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import d.c.c.b.d.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public d.c.c.b.f.a f29642a;

    public d() {
        d.c.c.b.f.a a2 = com.bytedance.sdk.openadsdk.i.e.a();
        this.f29642a = a2;
        if (a2 == null) {
            this.f29642a = new l();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.b
    public a a(f fVar) throws IOException, VAdError {
        Request<?> eVar = new e(fVar.f29643a, fVar.f29644b);
        if (fVar.f29645c != -1) {
            d.c.c.b.d.g gVar = new d.c.c.b.d.g();
            gVar.b((int) fVar.f29645c);
            eVar.setRetryPolicy(gVar);
        }
        return new g(this.f29642a.a(eVar, fVar.f29647e), fVar);
    }
}
