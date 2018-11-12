package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> iah;
    private final com.facebook.imagepipeline.c.f ifc;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> iit;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.iah = tVar;
        this.ifc = fVar;
        this.iit = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al bWM = ajVar.bWM();
        String id = ajVar.getId();
        bWM.cW(id, bWW());
        com.facebook.cache.common.b a = this.ifc.a(ajVar.bWL(), ajVar.bSo());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aG = this.iah.aG(a);
        if (aG != null) {
            boolean bWa = aG.get().bVP().bWa();
            if (bWa) {
                bWM.a(id, bWW(), bWM.yI(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.az(1.0f);
            }
            jVar.e(aG, bWa);
            aG.close();
            if (bWa) {
                return;
            }
        }
        if (ajVar.bWN().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            bWM.a(id, bWW(), bWM.yI(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        bWM.a(id, bWW(), bWM.yI(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
        this.iit.a(a2, ajVar);
    }

    protected j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final com.facebook.cache.common.b bVar) {
        return new m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>(jVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aG;
                if (aVar == null) {
                    if (z) {
                        bWY().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    bWY().e(aVar, z);
                } else {
                    if (!z && (aG = h.this.iah.aG(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g bVP = aVar.get().bVP();
                            com.facebook.imagepipeline.f.g bVP2 = aG.get().bVP();
                            if (bVP2.bWa() || bVP2.getQuality() >= bVP.getQuality()) {
                                bWY().e(aG, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aG);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.iah.a(bVar, aVar);
                    if (z) {
                        try {
                            bWY().az(1.0f);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bWY = bWY();
                    if (a != null) {
                        aVar = a;
                    }
                    bWY.e(aVar, z);
                }
            }
        };
    }

    protected String bWW() {
        return "BitmapMemoryCacheProducer";
    }
}
