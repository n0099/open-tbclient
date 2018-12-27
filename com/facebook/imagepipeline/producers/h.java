package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ikE;
    private final com.facebook.imagepipeline.c.f ipy;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> isP;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.ikE = tVar;
        this.ipy = fVar;
        this.isP = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al bZI = ajVar.bZI();
        String id = ajVar.getId();
        bZI.db(id, bZS());
        com.facebook.cache.common.b a = this.ipy.a(ajVar.bZH(), ajVar.bVk());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aH = this.ikE.aH(a);
        if (aH != null) {
            boolean bYW = aH.get().bYL().bYW();
            if (bYW) {
                bZI.a(id, bZS(), bZI.zo(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.az(1.0f);
            }
            jVar.e(aH, bYW);
            aH.close();
            if (bYW) {
                return;
            }
        }
        if (ajVar.bZJ().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            bZI.a(id, bZS(), bZI.zo(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        bZI.a(id, bZS(), bZI.zo(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
        this.isP.a(a2, ajVar);
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
                        bZU().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    bZU().e(aVar, z);
                } else {
                    if (!z && (aH = h.this.ikE.aH(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g bYL = aVar.get().bYL();
                            com.facebook.imagepipeline.f.g bYL2 = aH.get().bYL();
                            if (bYL2.bYW() || bYL2.getQuality() >= bYL.getQuality()) {
                                bZU().e(aH, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aH);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.ikE.a(bVar, aVar);
                    if (z) {
                        try {
                            bZU().az(1.0f);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZU = bZU();
                    if (a != null) {
                        aVar = a;
                    }
                    bZU.e(aVar, z);
                }
            }
        };
    }

    protected String bZS() {
        return "BitmapMemoryCacheProducer";
    }
}
