package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lTj;
    private final com.facebook.imagepipeline.c.f mbI;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> meH;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lTj = pVar;
        this.mbI = fVar;
        this.meH = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dtS = akVar.dtS();
        String id = akVar.getId();
        dtS.fi(id, dub());
        com.facebook.cache.common.b a = this.mbI.a(akVar.dtR(), akVar.dou());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> be = this.lTj.be(a);
        if (be != null) {
            boolean dta = be.get().dsM().dta();
            if (dta) {
                dtS.a(id, dub(), dtS.Oo(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dtS.D(id, dub(), true);
                kVar.au(1.0f);
            }
            kVar.h(be, b.vL(dta));
            be.close();
            if (dta) {
                return;
            }
        }
        if (akVar.dtT().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            dtS.a(id, dub(), dtS.Oo(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            dtS.D(id, dub(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.dtR().duQ());
        dtS.a(id, dub(), dtS.Oo(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.meH.c(a2, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> be;
                boolean Hr = Hr(i);
                if (aVar == null) {
                    if (Hr) {
                        dud().h(null, i);
                    }
                } else if (aVar.get().isStateful() || dl(i, 8)) {
                    dud().h(aVar, i);
                } else {
                    if (!Hr && (be = h.this.lTj.be(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dsM = aVar.get().dsM();
                            com.facebook.imagepipeline.g.h dsM2 = be.get().dsM();
                            if (dsM2.dta() || dsM2.dsY() >= dsM.dsY()) {
                                dud().h(be, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) be);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.lTj.a(bVar, aVar) : null;
                    if (Hr) {
                        try {
                            dud().au(1.0f);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dud = dud();
                    if (a != null) {
                        aVar = a;
                    }
                    dud.h(aVar, i);
                }
            }
        };
    }

    protected String dub() {
        return "BitmapMemoryCacheProducer";
    }
}
