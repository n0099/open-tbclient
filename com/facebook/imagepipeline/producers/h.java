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
        al bYS = ajVar.bYS();
        String id = ajVar.getId();
        bYS.db(id, bZc());
        com.facebook.cache.common.b a = this.imn.a(ajVar.bYR(), ajVar.bUu());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aH = this.ihu.aH(a);
        if (aH != null) {
            boolean bYg = aH.get().bXV().bYg();
            if (bYg) {
                bYS.a(id, bZc(), bYS.zl(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.az(1.0f);
            }
            jVar.e(aH, bYg);
            aH.close();
            if (bYg) {
                return;
            }
        }
        if (ajVar.bYT().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            bYS.a(id, bZc(), bYS.zl(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        bYS.a(id, bZc(), bYS.zl(id) ? ImmutableMap.of("cached_value_found", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) : null);
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
                        bZe().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    bZe().e(aVar, z);
                } else {
                    if (!z && (aH = h.this.ihu.aH(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g bXV = aVar.get().bXV();
                            com.facebook.imagepipeline.f.g bXV2 = aH.get().bXV();
                            if (bXV2.bYg() || bXV2.getQuality() >= bXV.getQuality()) {
                                bZe().e(aH, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aH);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.ihu.a(bVar, aVar);
                    if (z) {
                        try {
                            bZe().az(1.0f);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bZe = bZe();
                    if (a != null) {
                        aVar = a;
                    }
                    bZe.e(aVar, z);
                }
            }
        };
    }

    protected String bZc() {
        return "BitmapMemoryCacheProducer";
    }
}
