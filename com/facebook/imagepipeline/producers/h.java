package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mol;
    private final com.facebook.imagepipeline.c.f mwJ;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mzI;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.mol = pVar;
        this.mwJ = fVar;
        this.mzI = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dBx = akVar.dBx();
        String id = akVar.getId();
        dBx.fK(id, dBG());
        com.facebook.cache.common.b a = this.mwJ.a(akVar.dBw(), akVar.dwa());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bi = this.mol.bi(a);
        if (bi != null) {
            boolean dAG = bi.get().dAs().dAG();
            if (dAG) {
                dBx.a(id, dBG(), dBx.Qd(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dBx.F(id, dBG(), true);
                kVar.at(1.0f);
            }
            kVar.h(bi, b.wl(dAG));
            bi.close();
            if (dAG) {
                return;
            }
        }
        if (akVar.dBy().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            dBx.a(id, dBG(), dBx.Qd(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            dBx.F(id, dBG(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.dBw().dCv());
        dBx.a(id, dBG(), dBx.Qd(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.mzI.c(a2, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bi;
                boolean If = If(i);
                if (aVar == null) {
                    if (If) {
                        dBI().h(null, i);
                    }
                } else if (aVar.get().isStateful() || dq(i, 8)) {
                    dBI().h(aVar, i);
                } else {
                    if (!If && (bi = h.this.mol.bi(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dAs = aVar.get().dAs();
                            com.facebook.imagepipeline.g.h dAs2 = bi.get().dAs();
                            if (dAs2.dAG() || dAs2.dAE() >= dAs.dAE()) {
                                dBI().h(bi, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bi);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.mol.a(bVar, aVar) : null;
                    if (If) {
                        try {
                            dBI().at(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dBI = dBI();
                    if (a != null) {
                        aVar = a;
                    }
                    dBI.h(aVar, i);
                }
            }
        };
    }

    protected String dBG() {
        return "BitmapMemoryCacheProducer";
    }
}
