package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jBn;
    private final com.facebook.imagepipeline.c.f jGm;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jJF;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.jBn = tVar;
        this.jGm = fVar;
        this.jJF = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al czv = ajVar.czv();
        String id = ajVar.getId();
        czv.em(id, czF());
        com.facebook.cache.common.b a = this.jGm.a(ajVar.czu(), ajVar.cuQ());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aW = this.jBn.aW(a);
        if (aW != null) {
            boolean cyJ = aW.get().cyy().cyJ();
            if (cyJ) {
                czv.a(id, czF(), czv.FH(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aM(1.0f);
            }
            jVar.e(aW, cyJ);
            aW.close();
            if (cyJ) {
                return;
            }
        }
        if (ajVar.czw().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            czv.a(id, czF(), czv.FH(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        czv.a(id, czF(), czv.FH(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.jJF.a(a2, ajVar);
    }

    protected j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final com.facebook.cache.common.b bVar) {
        return new m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>(jVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void d(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aW;
                if (aVar == null) {
                    if (z) {
                        czH().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    czH().e(aVar, z);
                } else {
                    if (!z && (aW = h.this.jBn.aW(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g cyy = aVar.get().cyy();
                            com.facebook.imagepipeline.f.g cyy2 = aW.get().cyy();
                            if (cyy2.cyJ() || cyy2.getQuality() >= cyy.getQuality()) {
                                czH().e(aW, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(aW);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.jBn.a(bVar, aVar);
                    if (z) {
                        try {
                            czH().aM(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> czH = czH();
                    if (a != null) {
                        aVar = a;
                    }
                    czH.e(aVar, z);
                }
            }
        };
    }

    protected String czF() {
        return "BitmapMemoryCacheProducer";
    }
}
