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
        am dtR = akVar.dtR();
        String id = akVar.getId();
        dtR.fi(id, dua());
        com.facebook.cache.common.b a = this.mbI.a(akVar.dtQ(), akVar.dot());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> be = this.lTj.be(a);
        if (be != null) {
            boolean dsZ = be.get().dsL().dsZ();
            if (dsZ) {
                dtR.a(id, dua(), dtR.Oo(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dtR.D(id, dua(), true);
                kVar.au(1.0f);
            }
            kVar.h(be, b.vL(dsZ));
            be.close();
            if (dsZ) {
                return;
            }
        }
        if (akVar.dtS().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            dtR.a(id, dua(), dtR.Oo(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            dtR.D(id, dua(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.dtQ().duP());
        dtR.a(id, dua(), dtR.Oo(id) ? ImmutableMap.of("cached_value_found", "false") : null);
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
                        duc().h(null, i);
                    }
                } else if (aVar.get().isStateful() || dl(i, 8)) {
                    duc().h(aVar, i);
                } else {
                    if (!Hr && (be = h.this.lTj.be(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dsL = aVar.get().dsL();
                            com.facebook.imagepipeline.g.h dsL2 = be.get().dsL();
                            if (dsL2.dsZ() || dsL2.dsX() >= dsL.dsX()) {
                                duc().h(be, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) be);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.lTj.a(bVar, aVar) : null;
                    if (Hr) {
                        try {
                            duc().au(1.0f);
                        } finally {
                            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> duc = duc();
                    if (a != null) {
                        aVar = a;
                    }
                    duc.h(aVar, i);
                }
            }
        };
    }

    protected String dua() {
        return "BitmapMemoryCacheProducer";
    }
}
