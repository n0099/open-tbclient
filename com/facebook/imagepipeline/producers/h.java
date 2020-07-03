package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mKl;
    private final com.facebook.imagepipeline.c.f mSK;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mVP;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.mKl = pVar;
        this.mSK = fVar;
        this.mVP = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dFZ = akVar.dFZ();
        String id = akVar.getId();
        dFZ.fU(id, dGi());
        com.facebook.cache.common.b a = this.mSK.a(akVar.dFY(), akVar.dAD());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bj = this.mKl.bj(a);
        if (bj != null) {
            boolean dFi = bj.get().dEU().dFi();
            if (dFi) {
                dFZ.a(id, dGi(), dFZ.QP(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dFZ.G(id, dGi(), true);
                kVar.ay(1.0f);
            }
            kVar.h(bj, b.wH(dFi));
            bj.close();
            if (dFi) {
                return;
            }
        }
        if (akVar.dGa().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            dFZ.a(id, dGi(), dFZ.QP(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            dFZ.G(id, dGi(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.dFY().dGX());
        dFZ.a(id, dGi(), dFZ.QP(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.mVP.c(a2, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bj;
                boolean Jm = Jm(i);
                if (aVar == null) {
                    if (Jm) {
                        dGk().h(null, i);
                    }
                } else if (aVar.get().isStateful() || dz(i, 8)) {
                    dGk().h(aVar, i);
                } else {
                    if (!Jm && (bj = h.this.mKl.bj(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dEU = aVar.get().dEU();
                            com.facebook.imagepipeline.g.h dEU2 = bj.get().dEU();
                            if (dEU2.dFi() || dEU2.dFg() >= dEU.dFg()) {
                                dGk().h(bj, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bj);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.mKl.a(bVar, aVar) : null;
                    if (Jm) {
                        try {
                            dGk().ay(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dGk = dGk();
                    if (a != null) {
                        aVar = a;
                    }
                    dGk.h(aVar, i);
                }
            }
        };
    }

    protected String dGi() {
        return "BitmapMemoryCacheProducer";
    }
}
