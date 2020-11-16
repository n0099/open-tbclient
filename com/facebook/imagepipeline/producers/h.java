package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oOo;
    private final com.facebook.imagepipeline.c.f oWG;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oZF;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.oOo = pVar;
        this.oWG = fVar;
        this.oZF = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am eqU = akVar.eqU();
        String id = akVar.getId();
        eqU.gZ(id, erd());
        com.facebook.cache.common.b a2 = this.oWG.a(akVar.eqT(), akVar.elx());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bv = this.oOo.bv(a2);
        if (bv != null) {
            boolean eqd = bv.get().epP().eqd();
            if (eqd) {
                eqU.a(id, erd(), eqU.XX(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                eqU.I(id, erd(), true);
                kVar.aU(1.0f);
            }
            kVar.h(bv, b.Av(eqd));
            bv.close();
            if (eqd) {
                return;
            }
        }
        if (akVar.eqV().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            eqU.a(id, erd(), eqU.XX(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            eqU.I(id, erd(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a3 = a(kVar, a2, akVar.eqT().erS());
        eqU.a(id, erd(), eqU.XX(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.oZF.c(a3, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bv;
                boolean Ql = Ql(i);
                if (aVar == null) {
                    if (Ql) {
                        erf().h(null, i);
                    }
                } else if (aVar.get().isStateful() || ea(i, 8)) {
                    erf().h(aVar, i);
                } else {
                    if (!Ql && (bv = h.this.oOo.bv(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h epP = aVar.get().epP();
                            com.facebook.imagepipeline.g.h epP2 = bv.get().epP();
                            if (epP2.eqd() || epP2.eqb() >= epP.eqb()) {
                                erf().h(bv, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bv);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a2 = z ? h.this.oOo.a(bVar, aVar) : null;
                    if (Ql) {
                        try {
                            erf().aU(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a2);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> erf = erf();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    erf.h(aVar, i);
                }
            }
        };
    }

    protected String erd() {
        return "BitmapMemoryCacheProducer";
    }
}
