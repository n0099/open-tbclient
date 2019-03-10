package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jBG;
    private final com.facebook.imagepipeline.c.f jGF;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jJY;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.jBG = tVar;
        this.jGF = fVar;
        this.jJY = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al czF = ajVar.czF();
        String id = ajVar.getId();
        czF.em(id, czP());
        com.facebook.cache.common.b a = this.jGF.a(ajVar.czE(), ajVar.cva());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aX = this.jBG.aX(a);
        if (aX != null) {
            boolean cyT = aX.get().cyI().cyT();
            if (cyT) {
                czF.a(id, czP(), czF.FK(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aM(1.0f);
            }
            jVar.e(aX, cyT);
            aX.close();
            if (cyT) {
                return;
            }
        }
        if (ajVar.czG().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            czF.a(id, czP(), czF.FK(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        czF.a(id, czP(), czF.FK(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.jJY.a(a2, ajVar);
    }

    protected j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final com.facebook.cache.common.b bVar) {
        return new m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>(jVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aX;
                if (aVar == null) {
                    if (z) {
                        czR().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    czR().e(aVar, z);
                } else {
                    if (!z && (aX = h.this.jBG.aX(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g cyI = aVar.get().cyI();
                            com.facebook.imagepipeline.f.g cyI2 = aX.get().cyI();
                            if (cyI2.cyT() || cyI2.getQuality() >= cyI.getQuality()) {
                                czR().e(aX, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(aX);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.jBG.a(bVar, aVar);
                    if (z) {
                        try {
                            czR().aM(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> czR = czR();
                    if (a != null) {
                        aVar = a;
                    }
                    czR.e(aVar, z);
                }
            }
        };
    }

    protected String czP() {
        return "BitmapMemoryCacheProducer";
    }
}
