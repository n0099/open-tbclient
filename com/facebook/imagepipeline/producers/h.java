package com.facebook.imagepipeline.producers;

import com.baidu.webkit.internal.ABTestConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ihu;
    private final com.facebook.imagepipeline.c.f imn;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> ipF;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.ihu = tVar;
        this.imn = fVar;
        this.ipF = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al bYR = ajVar.bYR();
        String id = ajVar.getId();
        bYR.db(id, bZb());
        com.facebook.cache.common.b a = this.imn.a(ajVar.bYQ(), ajVar.bUt());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aH = this.ihu.aH(a);
        if (aH != null) {
            boolean bYf = aH.get().bXU().bYf();
            if (bYf) {
                bYR.a(id, bZb(), bYR.zl(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.az(1.0f);
            }
            jVar.e(aH, bYf);
            aH.close();
            if (bYf) {
                return;
            }
        }
        if (ajVar.bYS().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            bYR.a(id, bZb(), bYR.zl(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        bYR.a(id, bZb(), bYR.zl(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
        this.ipF.a(a2, ajVar);
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
                        bZd().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    bZd().e(aVar, z);
                } else {
                    if (!z && (aH = h.this.ihu.aH(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g bXU = aVar.get().bXU();
                            com.facebook.imagepipeline.f.g bXU2 = aH.get().bXU();
                            if (bXU2.bYf() || bXU2.getQuality() >= bXU.getQuality()) {
                                bZd().e(aH, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aH);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.ihu.a(bVar, aVar);
                    if (z) {
                        try {
                            bZd().az(1.0f);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZd = bZd();
                    if (a != null) {
                        aVar = a;
                    }
                    bZd.e(aVar, z);
                }
            }
        };
    }

    protected String bZb() {
        return "BitmapMemoryCacheProducer";
    }
}
