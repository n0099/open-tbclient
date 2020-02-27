package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJS;
    private final com.facebook.imagepipeline.c.f lRY;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lUZ;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lJS = pVar;
        this.lRY = fVar;
        this.lUZ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am drw = akVar.drw();
        String id = akVar.getId();
        drw.fm(id, drF());
        com.facebook.cache.common.b a = this.lRY.a(akVar.drv(), akVar.dmd());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bn = this.lJS.bn(a);
        if (bn != null) {
            boolean dqE = bn.get().dqq().dqE();
            if (dqE) {
                drw.a(id, drF(), drw.Pd(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                drw.D(id, drF(), true);
                kVar.aK(1.0f);
            }
            kVar.g(bn, b.vr(dqE));
            bn.close();
            if (dqE) {
                return;
            }
        }
        if (akVar.drx().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            drw.a(id, drF(), drw.Pd(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            drw.D(id, drF(), false);
            kVar.g(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.drv().dsv());
        drw.a(id, drF(), drw.Pd(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.lUZ.c(a2, akVar);
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
                        drH().g(null, i);
                    }
                } else if (aVar.get().isStateful() || dA(i, 8)) {
                    drH().g(aVar, i);
                } else {
                    if (!IJ && (bn = h.this.lJS.bn(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dqq = aVar.get().dqq();
                            com.facebook.imagepipeline.g.h dqq2 = bn.get().dqq();
                            if (dqq2.dqE() || dqq2.dqC() >= dqq.dqC()) {
                                drH().g(bn, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bn);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.lJS.a(bVar, aVar) : null;
                    if (IJ) {
                        try {
                            drH().aK(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> drH = drH();
                    if (a != null) {
                        aVar = a;
                    }
                    drH.g(aVar, i);
                }
            }
        };
    }

    protected String drF() {
        return "BitmapMemoryCacheProducer";
    }
}
