package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lKf;
    private final com.facebook.imagepipeline.c.f lSl;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lVm;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lKf = pVar;
        this.lSl = fVar;
        this.lVm = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am drz = akVar.drz();
        String id = akVar.getId();
        drz.fm(id, drI());
        com.facebook.cache.common.b a = this.lSl.a(akVar.dry(), akVar.dmg());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bn = this.lKf.bn(a);
        if (bn != null) {
            boolean dqH = bn.get().dqt().dqH();
            if (dqH) {
                drz.a(id, drI(), drz.Pe(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                drz.D(id, drI(), true);
                kVar.aK(1.0f);
            }
            kVar.g(bn, b.vr(dqH));
            bn.close();
            if (dqH) {
                return;
            }
        }
        if (akVar.drA().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            drz.a(id, drI(), drz.Pe(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            drz.D(id, drI(), false);
            kVar.g(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.dry().dsy());
        drz.a(id, drI(), drz.Pe(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.lVm.c(a2, akVar);
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
                        drK().g(null, i);
                    }
                } else if (aVar.get().isStateful() || dA(i, 8)) {
                    drK().g(aVar, i);
                } else {
                    if (!IJ && (bn = h.this.lKf.bn(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dqt = aVar.get().dqt();
                            com.facebook.imagepipeline.g.h dqt2 = bn.get().dqt();
                            if (dqt2.dqH() || dqt2.dqF() >= dqt.dqF()) {
                                drK().g(bn, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bn);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.lKf.a(bVar, aVar) : null;
                    if (IJ) {
                        try {
                            drK().aK(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> drK = drK();
                    if (a != null) {
                        aVar = a;
                    }
                    drK.g(aVar, i);
                }
            }
        };
    }

    protected String drI() {
        return "BitmapMemoryCacheProducer";
    }
}
