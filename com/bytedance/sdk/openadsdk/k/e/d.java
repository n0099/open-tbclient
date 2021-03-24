package com.bytedance.sdk.openadsdk.k.e;

import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import d.c.c.b.d.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public d.c.c.b.f.a f29641a;

    public d() {
        d.c.c.b.f.a a2 = com.bytedance.sdk.openadsdk.i.e.a();
        this.f29641a = a2;
        if (a2 == null) {
            this.f29641a = new l();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.b
    public a a(f fVar) throws IOException, VAdError {
        Request<?> eVar = new e(fVar.f29642a, fVar.f29643b);
        if (fVar.f29644c != -1) {
            d.c.c.b.d.g gVar = new d.c.c.b.d.g();
            gVar.b((int) fVar.f29644c);
            eVar.setRetryPolicy(gVar);
        }
        return new g(this.f29641a.a(eVar, fVar.f29646e), fVar);
    }
}
