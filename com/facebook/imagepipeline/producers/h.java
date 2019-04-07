package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jAS;
    private final com.facebook.imagepipeline.c.f jFR;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jJk;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.jAS = tVar;
        this.jFR = fVar;
        this.jJk = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al czB = ajVar.czB();
        String id = ajVar.getId();
        czB.em(id, czL());
        com.facebook.cache.common.b a = this.jFR.a(ajVar.czA(), ajVar.cuW());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aT = this.jAS.aT(a);
        if (aT != null) {
            boolean cyP = aT.get().cyE().cyP();
            if (cyP) {
                czB.a(id, czL(), czB.Fy(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aM(1.0f);
            }
            jVar.e(aT, cyP);
            aT.close();
            if (cyP) {
                return;
            }
        }
        if (ajVar.czC().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            czB.a(id, czL(), czB.Fy(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        czB.a(id, czL(), czB.Fy(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.jJk.a(a2, ajVar);
    }

    protected j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final com.facebook.cache.common.b bVar) {
        return new m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>(jVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aT;
                if (aVar == null) {
                    if (z) {
                        czN().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    czN().e(aVar, z);
                } else {
                    if (!z && (aT = h.this.jAS.aT(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g cyE = aVar.get().cyE();
                            com.facebook.imagepipeline.f.g cyE2 = aT.get().cyE();
                            if (cyE2.cyP() || cyE2.getQuality() >= cyE.getQuality()) {
                                czN().e(aT, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(aT);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.jAS.a(bVar, aVar);
                    if (z) {
                        try {
                            czN().aM(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> czN = czN();
                    if (a != null) {
                        aVar = a;
                    }
                    czN.e(aVar, z);
                }
            }
        };
    }

    protected String czL() {
        return "BitmapMemoryCacheProducer";
    }
}
