package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class h implements ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kbL;
    private final com.facebook.imagepipeline.c.f kgN;
    private final ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> kkh;

    public h(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        this.kbL = tVar;
        this.kgN = fVar;
        this.kkh = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, aj ajVar) {
        al cIG = ajVar.cIG();
        String id = ajVar.getId();
        cIG.en(id, cIQ());
        com.facebook.cache.common.b a = this.kgN.a(ajVar.cIF(), ajVar.cDZ());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aQ = this.kbL.aQ(a);
        if (aQ != null) {
            boolean cHU = aQ.get().cHI().cHU();
            if (cHU) {
                cIG.a(id, cIQ(), cIG.GH(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                jVar.av(1.0f);
            }
            jVar.f(aQ, cHU);
            aQ.close();
            if (cHU) {
                return;
            }
        }
        if (ajVar.cIH().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            cIG.a(id, cIQ(), cIG.GH(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            jVar.f(null, true);
            return;
        }
        j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a2 = a(jVar, a);
        cIG.a(id, cIQ(), cIG.GH(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.kkh.a(a2, ajVar);
    }

    protected j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, final com.facebook.cache.common.b bVar) {
        return new m<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>(jVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar, boolean z) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aQ;
                if (aVar == null) {
                    if (z) {
                        cIS().f(null, true);
                    }
                } else if (aVar.get().isStateful()) {
                    cIS().f(aVar, z);
                } else {
                    if (!z && (aQ = h.this.kbL.aQ(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.g cHI = aVar.get().cHI();
                            com.facebook.imagepipeline.f.g cHI2 = aQ.get().cHI();
                            if (cHI2.cHU() || cHI2.cHS() >= cHI.cHS()) {
                                cIS().f(aQ, false);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aQ);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.b> a = h.this.kbL.a(bVar, aVar);
                    if (z) {
                        try {
                            cIS().av(1.0f);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                    j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> cIS = cIS();
                    if (a != null) {
                        aVar = a;
                    }
                    cIS.f(aVar, z);
                }
            }
        };
    }

    protected String cIQ() {
        return "BitmapMemoryCacheProducer";
    }
}
