package com.bytedance.sdk.openadsdk.k.e;

import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import d.b.c.b.d.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.b.f.a f29514a;

    public d() {
        d.b.c.b.f.a a2 = com.bytedance.sdk.openadsdk.i.e.a();
        this.f29514a = a2;
        if (a2 == null) {
            this.f29514a = new l();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.b
    public a a(f fVar) throws IOException, VAdError {
        Request<?> eVar = new e(fVar.f29515a, fVar.f29516b);
        if (fVar.f29517c != -1) {
            d.b.c.b.d.g gVar = new d.b.c.b.d.g();
            gVar.b((int) fVar.f29517c);
            eVar.setRetryPolicy(gVar);
        }
        return new g(this.f29514a.a(eVar, fVar.f29519e), fVar);
    }
}
