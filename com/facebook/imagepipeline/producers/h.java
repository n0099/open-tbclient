package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJU;
    private final com.facebook.imagepipeline.c.f lSa;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lVb;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lJU = pVar;
        this.lSa = fVar;
        this.lVb = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dry = akVar.dry();
        String id = akVar.getId();
        dry.fm(id, drH());
        com.facebook.cache.common.b a = this.lSa.a(akVar.drx(), akVar.dmf());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bn = this.lJU.bn(a);
        if (bn != null) {
            boolean dqG = bn.get().dqs().dqG();
            if (dqG) {
                dry.a(id, drH(), dry.Pd(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dry.D(id, drH(), true);
                kVar.aK(1.0f);
            }
            kVar.g(bn, b.vr(dqG));
            bn.close();
            if (dqG) {
                return;
            }
        }
        if (akVar.drz().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            dry.a(id, drH(), dry.Pd(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            dry.D(id, drH(), false);
            kVar.g(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.drx().dsx());
        dry.a(id, drH(), dry.Pd(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.lVb.c(a2, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bn;
                boolean IJ = IJ(i);
                if (aVar == null) {
                    if (IJ) {
                        drJ().g(null, i);
                    }
                } else if (aVar.get().isStateful() || dA(i, 8)) {
                    drJ().g(aVar, i);
                } else {
                    if (!IJ && (bn = h.this.lJU.bn(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dqs = aVar.get().dqs();
                            com.facebook.imagepipeline.g.h dqs2 = bn.get().dqs();
                            if (dqs2.dqG() || dqs2.dqE() >= dqs.dqE()) {
                                drJ().g(bn, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bn);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.lJU.a(bVar, aVar) : null;
                    if (IJ) {
                        try {
                            drJ().aK(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> drJ = drJ();
                    if (a != null) {
                        aVar = a;
                    }
                    drJ.g(aVar, i);
                }
            }
        };
    }

    protected String drH() {
        return "BitmapMemoryCacheProducer";
    }
}
