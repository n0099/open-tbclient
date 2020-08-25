package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes8.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nmn;
    private final com.facebook.imagepipeline.c.f nuK;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nxL;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.nmn = pVar;
        this.nuK = fVar;
        this.nxL = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dVp = akVar.dVp();
        String id = akVar.getId();
        dVp.gn(id, dVy());
        com.facebook.cache.common.b a = this.nuK.a(akVar.dVo(), akVar.dPU());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bl = this.nmn.bl(a);
        if (bl != null) {
            boolean dUy = bl.get().dUk().dUy();
            if (dUy) {
                dVp.a(id, dVy(), dVp.UF(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dVp.F(id, dVy(), true);
                kVar.aD(1.0f);
            }
            kVar.h(bl, b.yd(dUy));
            bl.close();
            if (dUy) {
                return;
            }
        }
        if (akVar.dVq().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            dVp.a(id, dVy(), dVp.UF(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            dVp.F(id, dVy(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.dVo().dWn());
        dVp.a(id, dVy(), dVp.UF(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.nxL.c(a2, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bl;
                boolean Ml = Ml(i);
                if (aVar == null) {
                    if (Ml) {
                        dVA().h(null, i);
                    }
                } else if (aVar.get().isStateful() || dJ(i, 8)) {
                    dVA().h(aVar, i);
                } else {
                    if (!Ml && (bl = h.this.nmn.bl(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dUk = aVar.get().dUk();
                            com.facebook.imagepipeline.g.h dUk2 = bl.get().dUk();
                            if (dUk2.dUy() || dUk2.dUw() >= dUk.dUw()) {
                                dVA().h(bl, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bl);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.nmn.a(bVar, aVar) : null;
                    if (Ml) {
                        try {
                            dVA().aD(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dVA = dVA();
                    if (a != null) {
                        aVar = a;
                    }
                    dVA.h(aVar, i);
                }
            }
        };
    }

    protected String dVy() {
        return "BitmapMemoryCacheProducer";
    }
}
