package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final com.facebook.imagepipeline.b.f pBa;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pDZ;
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> puD;

    public h(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.puD = pVar;
        this.pBa = fVar;
        this.pDZ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am eAe = akVar.eAe();
        String id = akVar.getId();
        eAe.hm(id, eAo());
        com.facebook.cache.common.b a2 = this.pBa.a(akVar.eAd(), akVar.evp());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.puD.bu(a2);
        if (bu != null) {
            boolean ezq = bu.get().ezd().ezq();
            if (ezq) {
                eAe.b(id, eAo(), eAe.ZA(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                eAe.M(id, eAo(), true);
                kVar.aX(1.0f);
            }
            kVar.g(bu, b.Be(ezq));
            bu.close();
            if (ezq) {
                return;
            }
        }
        if (akVar.eAf().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            eAe.b(id, eAo(), eAe.ZA(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            eAe.M(id, eAo(), false);
            kVar.g(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a3 = a(kVar, a2, akVar.eAd().eBa());
        eAe.b(id, eAo(), eAe.ZA(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.pDZ.a(a3, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu;
                boolean Rf = Rf(i);
                if (aVar == null) {
                    if (Rf) {
                        eAq().g(null, i);
                    }
                } else if (aVar.get().isStateful() || ed(i, 8)) {
                    eAq().g(aVar, i);
                } else {
                    if (!Rf && (bu = h.this.puD.bu(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.h ezd = aVar.get().ezd();
                            com.facebook.imagepipeline.f.h ezd2 = bu.get().ezd();
                            if (ezd2.ezq() || ezd2.ezo() >= ezd.ezo()) {
                                eAq().g(bu, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bu);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = z ? h.this.puD.a(bVar, aVar) : null;
                    if (Rf) {
                        try {
                            eAq().aX(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a2);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eAq = eAq();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    eAq.g(aVar, i);
                }
            }
        };
    }

    protected String eAo() {
        return "BitmapMemoryCacheProducer";
    }
}
