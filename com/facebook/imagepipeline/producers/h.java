package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes9.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lFI;
    private final com.facebook.imagepipeline.c.f lNA;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lQz;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lFI = pVar;
        this.lNA = fVar;
        this.lQz = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am doY = akVar.doY();
        String id = akVar.getId();
        doY.fc(id, dph());
        com.facebook.cache.common.b a = this.lNA.a(akVar.doX(), akVar.djN());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bk = this.lFI.bk(a);
        if (bk != null) {
            boolean dok = bk.get().dnW().dok();
            if (dok) {
                doY.a(id, dph(), doY.OF(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                doY.C(id, dph(), true);
                kVar.aM(1.0f);
            }
            kVar.g(bk, b.vb(dok));
            bk.close();
            if (dok) {
                return;
            }
        }
        if (akVar.doZ().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            doY.a(id, dph(), doY.OF(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            doY.C(id, dph(), false);
            kVar.g(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.doX().dpU());
        doY.a(id, dph(), doY.OF(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.lQz.c(a2, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bk;
                boolean Iv = Iv(i);
                if (aVar == null) {
                    if (Iv) {
                        dpj().g(null, i);
                    }
                } else if (aVar.get().isStateful() || dz(i, 8)) {
                    dpj().g(aVar, i);
                } else {
                    if (!Iv && (bk = h.this.lFI.bk(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dnW = aVar.get().dnW();
                            com.facebook.imagepipeline.g.h dnW2 = bk.get().dnW();
                            if (dnW2.dok() || dnW2.doi() >= dnW.doi()) {
                                dpj().g(bk, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bk);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.lFI.a(bVar, aVar) : null;
                    if (Iv) {
                        try {
                            dpj().aM(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dpj = dpj();
                    if (a != null) {
                        aVar = a;
                    }
                    dpj.g(aVar, i);
                }
            }
        };
    }

    protected String dph() {
        return "BitmapMemoryCacheProducer";
    }
}
