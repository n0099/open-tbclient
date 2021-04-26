package com.bytedance.sdk.openadsdk.k.e;

import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import d.b.c.b.d.l;
import java.io.IOException;
/* loaded from: classes5.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.b.f.a f30237a;

    public d() {
        d.b.c.b.f.a a2 = com.bytedance.sdk.openadsdk.i.e.a();
        this.f30237a = a2;
        if (a2 == null) {
            this.f30237a = new l();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.b
    public a a(f fVar) throws IOException, VAdError {
        Request<?> eVar = new e(fVar.f30238a, fVar.f30239b);
        if (fVar.f30240c != -1) {
            d.b.c.b.d.g gVar = new d.b.c.b.d.g();
            gVar.b((int) fVar.f30240c);
            eVar.setRetryPolicy(gVar);
        }
        return new g(this.f30237a.a(eVar, fVar.f30242e), fVar);
    }
}
