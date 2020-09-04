package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes8.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nmF;
    private final com.facebook.imagepipeline.c.f nvc;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nyd;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.nmF = pVar;
        this.nvc = fVar;
        this.nyd = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dVy = akVar.dVy();
        String id = akVar.getId();
        dVy.go(id, dVH());
        com.facebook.cache.common.b a = this.nvc.a(akVar.dVx(), akVar.dQd());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bl = this.nmF.bl(a);
        if (bl != null) {
            boolean dUH = bl.get().dUt().dUH();
            if (dUH) {
                dVy.a(id, dVH(), dVy.UF(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dVy.F(id, dVH(), true);
                kVar.aD(1.0f);
            }
            kVar.h(bl, b.yf(dUH));
            bl.close();
            if (dUH) {
                return;
            }
        }
        if (akVar.dVz().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            dVy.a(id, dVH(), dVy.UF(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            dVy.F(id, dVH(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.dVx().dWw());
        dVy.a(id, dVH(), dVy.UF(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.nyd.c(a2, akVar);
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
                        dVJ().h(null, i);
                    }
                } else if (aVar.get().isStateful() || dJ(i, 8)) {
                    dVJ().h(aVar, i);
                } else {
                    if (!Ml && (bl = h.this.nmF.bl(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dUt = aVar.get().dUt();
                            com.facebook.imagepipeline.g.h dUt2 = bl.get().dUt();
                            if (dUt2.dUH() || dUt2.dUF() >= dUt.dUF()) {
                                dVJ().h(bl, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bl);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.nmF.a(bVar, aVar) : null;
                    if (Ml) {
                        try {
                            dVJ().aD(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dVJ = dVJ();
                    if (a != null) {
                        aVar = a;
                    }
                    dVJ.h(aVar, i);
                }
            }
        };
    }

    protected String dVH() {
        return "BitmapMemoryCacheProducer";
    }
}
