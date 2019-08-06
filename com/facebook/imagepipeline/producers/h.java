package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kbW;
    private final com.facebook.imagepipeline.c.f kgV;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kkp;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.kbW = tVar;
        this.kgV = fVar;
        this.kkp = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cKX = ajVar.cKX();
        String id = ajVar.getId();
        cKX.eA(id, cLh());
        com.facebook.cache.common.b a = this.kgV.a(ajVar.cKW(), ajVar.cGp());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aV = this.kbW.aV(a);
        if (aV != null) {
            boolean cKl = aV.get().cJZ().cKl();
            if (cKl) {
                cKX.a(id, cLh(), cKX.HQ(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aR(1.0f);
            }
            jVar.e(aV, cKl);
            aV.close();
            if (cKl) {
                return;
            }
        }
        if (ajVar.cKY().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            cKX.a(id, cLh(), cKX.HQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        cKX.a(id, cLh(), cKX.HQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kkp.a(a2, ajVar);
    }

    protected j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final com.facebook.cache.common.b bVar) {
        return new m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>(jVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aV;
                if (aVar == null) {
                    if (z) {
                        cLj().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    cLj().e(aVar, z);
                } else {
                    if (!z && (aV = h.this.kbW.aV(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g cJZ = aVar.get().cJZ();
                            com.facebook.imagepipeline.f.g cJZ2 = aV.get().cJZ();
                            if (cJZ2.cKl() || cJZ2.cKj() >= cJZ.cKj()) {
                                cLj().e(aV, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(aV);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.kbW.a(bVar, aVar);
                    if (z) {
                        try {
                            cLj().aR(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cLj = cLj();
                    if (a != null) {
                        aVar = a;
                    }
                    cLj.e(aVar, z);
                }
            }
        };
    }

    protected String cLh() {
        return "BitmapMemoryCacheProducer";
    }
}
