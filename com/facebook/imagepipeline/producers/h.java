package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mnb;
    private final com.facebook.imagepipeline.c.f mvz;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> myy;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.mnb = pVar;
        this.mvz = fVar;
        this.myy = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dBj = akVar.dBj();
        String id = akVar.getId();
        dBj.fK(id, dBs());
        com.facebook.cache.common.b a = this.mvz.a(akVar.dBi(), akVar.dvM());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bi = this.mnb.bi(a);
        if (bi != null) {
            boolean dAs = bi.get().dAe().dAs();
            if (dAs) {
                dBj.a(id, dBs(), dBj.Qc(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dBj.F(id, dBs(), true);
                kVar.at(1.0f);
            }
            kVar.h(bi, b.wj(dAs));
            bi.close();
            if (dAs) {
                return;
            }
        }
        if (akVar.dBk().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            dBj.a(id, dBs(), dBj.Qc(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            dBj.F(id, dBs(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.dBi().dCh());
        dBj.a(id, dBs(), dBj.Qc(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.myy.c(a2, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bi;
                boolean Id = Id(i);
                if (aVar == null) {
                    if (Id) {
                        dBu().h(null, i);
                    }
                } else if (aVar.get().isStateful() || dq(i, 8)) {
                    dBu().h(aVar, i);
                } else {
                    if (!Id && (bi = h.this.mnb.bi(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dAe = aVar.get().dAe();
                            com.facebook.imagepipeline.g.h dAe2 = bi.get().dAe();
                            if (dAe2.dAs() || dAe2.dAq() >= dAe.dAq()) {
                                dBu().h(bi, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bi);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.mnb.a(bVar, aVar) : null;
                    if (Id) {
                        try {
                            dBu().at(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dBu = dBu();
                    if (a != null) {
                        aVar = a;
                    }
                    dBu.h(aVar, i);
                }
            }
        };
    }

    protected String dBs() {
        return "BitmapMemoryCacheProducer";
    }
}
