package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lTf;
    private final com.facebook.imagepipeline.c.f mbE;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> meD;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lTf = pVar;
        this.mbE = fVar;
        this.meD = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dtU = akVar.dtU();
        String id = akVar.getId();
        dtU.fi(id, dud());
        com.facebook.cache.common.b a = this.mbE.a(akVar.dtT(), akVar.dow());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bd = this.lTf.bd(a);
        if (bd != null) {
            boolean dtc = bd.get().dsO().dtc();
            if (dtc) {
                dtU.a(id, dud(), dtU.Ol(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dtU.D(id, dud(), true);
                kVar.au(1.0f);
            }
            kVar.h(bd, b.vL(dtc));
            bd.close();
            if (dtc) {
                return;
            }
        }
        if (akVar.dtV().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            dtU.a(id, dud(), dtU.Ol(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            dtU.D(id, dud(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.dtT().duS());
        dtU.a(id, dud(), dtU.Ol(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.meD.c(a2, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bd;
                boolean Hr = Hr(i);
                if (aVar == null) {
                    if (Hr) {
                        duf().h(null, i);
                    }
                } else if (aVar.get().isStateful() || dl(i, 8)) {
                    duf().h(aVar, i);
                } else {
                    if (!Hr && (bd = h.this.lTf.bd(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dsO = aVar.get().dsO();
                            com.facebook.imagepipeline.g.h dsO2 = bd.get().dsO();
                            if (dsO2.dtc() || dsO2.dta() >= dsO.dta()) {
                                duf().h(bd, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) bd);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.lTf.a(bVar, aVar) : null;
                    if (Hr) {
                        try {
                            duf().au(1.0f);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> duf = duf();
                    if (a != null) {
                        aVar = a;
                    }
                    duf.h(aVar, i);
                }
            }
        };
    }

    protected String dud() {
        return "BitmapMemoryCacheProducer";
    }
}
