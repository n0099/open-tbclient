package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jBy;
    private final com.facebook.imagepipeline.c.f jGx;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jJQ;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.jBy = tVar;
        this.jGx = fVar;
        this.jJQ = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al czI = ajVar.czI();
        String id = ajVar.getId();
        czI.el(id, czS());
        com.facebook.cache.common.b a = this.jGx.a(ajVar.czH(), ajVar.cvd());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aX = this.jBy.aX(a);
        if (aX != null) {
            boolean cyW = aX.get().cyL().cyW();
            if (cyW) {
                czI.a(id, czS(), czI.FI(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aM(1.0f);
            }
            jVar.e(aX, cyW);
            aX.close();
            if (cyW) {
                return;
            }
        }
        if (ajVar.czJ().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            czI.a(id, czS(), czI.FI(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        czI.a(id, czS(), czI.FI(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.jJQ.a(a2, ajVar);
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
                        czU().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    czU().e(aVar, z);
                } else {
                    if (!z && (aX = h.this.jBy.aX(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g cyL = aVar.get().cyL();
                            com.facebook.imagepipeline.f.g cyL2 = aX.get().cyL();
                            if (cyL2.cyW() || cyL2.getQuality() >= cyL.getQuality()) {
                                czU().e(aX, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(aX);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.jBy.a(bVar, aVar);
                    if (z) {
                        try {
                            czU().aM(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> czU = czU();
                    if (a != null) {
                        aVar = a;
                    }
                    czU.e(aVar, z);
                }
            }
        };
    }

    protected String czS() {
        return "BitmapMemoryCacheProducer";
    }
}
