package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> jTI;
    private final com.facebook.imagepipeline.c.f jYF;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kbY;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.jTI = tVar;
        this.jYF = fVar;
        this.kbY = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cHx = ajVar.cHx();
        String id = ajVar.getId();
        cHx.ez(id, cHH());
        com.facebook.cache.common.b a = this.jYF.a(ajVar.cHw(), ajVar.cCS());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aV = this.jTI.aV(a);
        if (aV != null) {
            boolean cGL = aV.get().cGA().cGL();
            if (cGL) {
                cHx.a(id, cHH(), cHx.GT(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.aQ(1.0f);
            }
            jVar.e(aV, cGL);
            aV.close();
            if (cGL) {
                return;
            }
        }
        if (ajVar.cHy().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            cHx.a(id, cHH(), cHx.GT(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            jVar.e(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        cHx.a(id, cHH(), cHx.GT(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kbY.a(a2, ajVar);
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
                        cHJ().e(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    cHJ().e(aVar, z);
                } else {
                    if (!z && (aV = h.this.jTI.aV(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g cGA = aVar.get().cGA();
                            com.facebook.imagepipeline.f.g cGA2 = aV.get().cGA();
                            if (cGA2.cGL() || cGA2.getQuality() >= cGA.getQuality()) {
                                cHJ().e(aV, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(aV);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.jTI.a(bVar, aVar);
                    if (z) {
                        try {
                            cHJ().aQ(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cHJ = cHJ();
                    if (a != null) {
                        aVar = a;
                    }
                    cHJ.e(aVar, z);
                }
            }
        };
    }

    protected String cHH() {
        return "BitmapMemoryCacheProducer";
    }
}
