package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes3.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final com.facebook.imagepipeline.b.f pCH;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pFG;
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> puK;

    public h(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.puK = pVar;
        this.pCH = fVar;
        this.pFG = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am eAI = akVar.eAI();
        String id = akVar.getId();
        eAI.hn(id, eAS());
        com.facebook.cache.common.b a2 = this.pCH.a(akVar.eAH(), akVar.evw());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.puK.bu(a2);
        if (bu != null) {
            boolean ezU = bu.get().ezG().ezU();
            if (ezU) {
                eAI.b(id, eAS(), eAI.ZA(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                eAI.M(id, eAS(), true);
                kVar.aX(1.0f);
            }
            kVar.g(bu, b.Be(ezU));
            bu.close();
            if (ezU) {
                return;
            }
        }
        if (akVar.eAJ().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            eAI.b(id, eAS(), eAI.ZA(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            eAI.M(id, eAS(), false);
            kVar.g(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a3 = a(kVar, a2, akVar.eAH().eBE());
        eAI.b(id, eAS(), eAI.ZA(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.pFG.a(a3, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu;
                boolean Rv = Rv(i);
                if (aVar == null) {
                    if (Rv) {
                        eAU().g(null, i);
                    }
                } else if (aVar.get().isStateful() || ef(i, 8)) {
                    eAU().g(aVar, i);
                } else {
                    if (!Rv && (bu = h.this.puK.bu(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.h ezG = aVar.get().ezG();
                            com.facebook.imagepipeline.f.h ezG2 = bu.get().ezG();
                            if (ezG2.ezU() || ezG2.ezS() >= ezG.ezS()) {
                                eAU().g(bu, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bu);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = z ? h.this.puK.a(bVar, aVar) : null;
                    if (Rv) {
                        try {
                            eAU().aX(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a2);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eAU = eAU();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    eAU.g(aVar, i);
                }
            }
        };
    }

    protected String eAS() {
        return "BitmapMemoryCacheProducer";
    }
}
