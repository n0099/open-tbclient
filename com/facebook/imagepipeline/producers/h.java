package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jTJ;
    private final com.facebook.imagepipeline.c.f jYG;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kbZ;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.jTJ = tVar;
        this.jYG = fVar;
        this.kbZ = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cHz = ajVar.cHz();
        String id = ajVar.getId();
        cHz.ez(id, cHJ());
        com.facebook.cache.common.b a = this.jYG.a(ajVar.cHy(), ajVar.cCU());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aV = this.jTJ.aV(a);
        if (aV != null) {
            boolean cGN = aV.get().cGC().cGN();
            if (cGN) {
                cHz.a(id, cHJ(), cHz.GT(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aQ(1.0f);
            }
            jVar.e(aV, cGN);
            aV.close();
            if (cGN) {
                return;
            }
        }
        if (ajVar.cHA().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            cHz.a(id, cHJ(), cHz.GT(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        cHz.a(id, cHJ(), cHz.GT(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kbZ.a(a2, ajVar);
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
                        cHL().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    cHL().e(aVar, z);
                } else {
                    if (!z && (aV = h.this.jTJ.aV(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g cGC = aVar.get().cGC();
                            com.facebook.imagepipeline.f.g cGC2 = aV.get().cGC();
                            if (cGC2.cGN() || cGC2.getQuality() >= cGC.getQuality()) {
                                cHL().e(aV, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(aV);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.jTJ.a(bVar, aVar);
                    if (z) {
                        try {
                            cHL().aQ(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHL = cHL();
                    if (a != null) {
                        aVar = a;
                    }
                    cHL.e(aVar, z);
                }
            }
        };
    }

    protected String cHJ() {
        return "BitmapMemoryCacheProducer";
    }
}
