package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pAS;
    private final com.facebook.imagepipeline.b.f pIP;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pLO;

    public h(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.pAS = pVar;
        this.pIP = fVar;
        this.pLO = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am ezq = akVar.ezq();
        String id = akVar.getId();
        ezq.hv(id, ezA());
        com.facebook.cache.common.b a2 = this.pIP.a(akVar.ezp(), akVar.eud());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.pAS.bu(a2);
        if (bu != null) {
            boolean eyC = bu.get().eyp().eyC();
            if (eyC) {
                ezq.b(id, ezA(), ezq.ZG(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                ezq.M(id, ezA(), true);
                kVar.ba(1.0f);
            }
            kVar.g(bu, b.Bt(eyC));
            bu.close();
            if (eyC) {
                return;
            }
        }
        if (akVar.ezr().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            ezq.b(id, ezA(), ezq.ZG(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            ezq.M(id, ezA(), false);
            kVar.g(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a3 = a(kVar, a2, akVar.ezp().eAm());
        ezq.b(id, ezA(), ezq.ZG(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.pLO.a(a3, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu;
                boolean Qk = Qk(i);
                if (aVar == null) {
                    if (Qk) {
                        ezC().g(null, i);
                    }
                } else if (aVar.get().isStateful() || ed(i, 8)) {
                    ezC().g(aVar, i);
                } else {
                    if (!Qk && (bu = h.this.pAS.bu(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.h eyp = aVar.get().eyp();
                            com.facebook.imagepipeline.f.h eyp2 = bu.get().eyp();
                            if (eyp2.eyC() || eyp2.getQuality() >= eyp.getQuality()) {
                                ezC().g(bu, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bu);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = z ? h.this.pAS.a(bVar, aVar) : null;
                    if (Qk) {
                        try {
                            ezC().ba(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a2);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ezC = ezC();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    ezC.g(aVar, i);
                }
            }
        };
    }

    protected String ezA() {
        return "BitmapMemoryCacheProducer";
    }
}
