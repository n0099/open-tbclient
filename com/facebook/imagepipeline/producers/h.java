package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kaQ;
    private final com.facebook.imagepipeline.c.f kfP;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kjj;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.kaQ = tVar;
        this.kfP = fVar;
        this.kjj = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cKC = ajVar.cKC();
        String id = ajVar.getId();
        cKC.eA(id, cKM());
        com.facebook.cache.common.b a = this.kfP.a(ajVar.cKB(), ajVar.cFU());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aV = this.kaQ.aV(a);
        if (aV != null) {
            boolean cJQ = aV.get().cJE().cJQ();
            if (cJQ) {
                cKC.a(id, cKM(), cKC.HP(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aR(1.0f);
            }
            jVar.e(aV, cJQ);
            aV.close();
            if (cJQ) {
                return;
            }
        }
        if (ajVar.cKD().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            cKC.a(id, cKM(), cKC.HP(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        cKC.a(id, cKM(), cKC.HP(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kjj.a(a2, ajVar);
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
                        cKO().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    cKO().e(aVar, z);
                } else {
                    if (!z && (aV = h.this.kaQ.aV(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g cJE = aVar.get().cJE();
                            com.facebook.imagepipeline.f.g cJE2 = aV.get().cJE();
                            if (cJE2.cJQ() || cJE2.cJO() >= cJE.cJO()) {
                                cKO().e(aV, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(aV);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.kaQ.a(bVar, aVar);
                    if (z) {
                        try {
                            cKO().aR(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cKO = cKO();
                    if (a != null) {
                        aVar = a;
                    }
                    cKO.e(aVar, z);
                }
            }
        };
    }

    protected String cKM() {
        return "BitmapMemoryCacheProducer";
    }
}
