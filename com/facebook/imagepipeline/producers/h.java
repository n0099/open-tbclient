package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ilL;
    private final com.facebook.imagepipeline.c.f iqF;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> itW;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.ilL = tVar;
        this.iqF = fVar;
        this.itW = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al caq = ajVar.caq();
        String id = ajVar.getId();
        caq.de(id, caA());
        com.facebook.cache.common.b a = this.iqF.a(ajVar.cap(), ajVar.bVS());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aH = this.ilL.aH(a);
        if (aH != null) {
            boolean bZE = aH.get().bZt().bZE();
            if (bZE) {
                caq.a(id, caA(), caq.zE(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.az(1.0f);
            }
            jVar.e(aH, bZE);
            aH.close();
            if (bZE) {
                return;
            }
        }
        if (ajVar.car().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            caq.a(id, caA(), caq.zE(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        caq.a(id, caA(), caq.zE(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
        this.itW.a(a2, ajVar);
    }

    protected j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final com.facebook.cache.common.b bVar) {
        return new m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>(jVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aH;
                if (aVar == null) {
                    if (z) {
                        caC().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    caC().e(aVar, z);
                } else {
                    if (!z && (aH = h.this.ilL.aH(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g bZt = aVar.get().bZt();
                            com.facebook.imagepipeline.f.g bZt2 = aH.get().bZt();
                            if (bZt2.bZE() || bZt2.getQuality() >= bZt.getQuality()) {
                                caC().e(aH, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aH);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.ilL.a(bVar, aVar);
                    if (z) {
                        try {
                            caC().az(1.0f);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> caC = caC();
                    if (a != null) {
                        aVar = a;
                    }
                    caC.e(aVar, z);
                }
            }
        };
    }

    protected String caA() {
        return "BitmapMemoryCacheProducer";
    }
}
