package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oMK;
    private final com.facebook.imagepipeline.c.f oVd;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oYc;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.oMK = pVar;
        this.oVd = fVar;
        this.oYc = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am eqW = akVar.eqW();
        String id = akVar.getId();
        eqW.gZ(id, erf());
        com.facebook.cache.common.b a2 = this.oVd.a(akVar.eqV(), akVar.elz());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bu = this.oMK.bu(a2);
        if (bu != null) {
            boolean eqf = bu.get().epR().eqf();
            if (eqf) {
                eqW.a(id, erf(), eqW.Ym(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                eqW.H(id, erf(), true);
                kVar.aN(1.0f);
            }
            kVar.h(bu, b.Ao(eqf));
            bu.close();
            if (eqf) {
                return;
            }
        }
        if (akVar.eqX().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            eqW.a(id, erf(), eqW.Ym(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            eqW.H(id, erf(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a3 = a(kVar, a2, akVar.eqV().erU());
        eqW.a(id, erf(), eqW.Ym(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.oYc.c(a3, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bu;
                boolean PI = PI(i);
                if (aVar == null) {
                    if (PI) {
                        erh().h(null, i);
                    }
                } else if (aVar.get().isStateful() || dZ(i, 8)) {
                    erh().h(aVar, i);
                } else {
                    if (!PI && (bu = h.this.oMK.bu(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h epR = aVar.get().epR();
                            com.facebook.imagepipeline.g.h epR2 = bu.get().epR();
                            if (epR2.eqf() || epR2.eqd() >= epR.eqd()) {
                                erh().h(bu, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bu);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a2 = z ? h.this.oMK.a(bVar, aVar) : null;
                    if (PI) {
                        try {
                            erh().aN(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a2);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> erh = erh();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    erh.h(aVar, i);
                }
            }
        };
    }

    protected String erf() {
        return "BitmapMemoryCacheProducer";
    }
}
