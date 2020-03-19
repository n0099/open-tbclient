package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lLL;
    private final com.facebook.imagepipeline.c.f lTR;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lWS;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lLL = pVar;
        this.lTR = fVar;
        this.lWS = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am drW = akVar.drW();
        String id = akVar.getId();
        drW.fk(id, dsf());
        com.facebook.cache.common.b a = this.lTR.a(akVar.drV(), akVar.dmD());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bn = this.lLL.bn(a);
        if (bn != null) {
            boolean dre = bn.get().dqQ().dre();
            if (dre) {
                drW.a(id, dsf(), drW.Pe(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                drW.D(id, dsf(), true);
                kVar.aK(1.0f);
            }
            kVar.g(bn, b.vy(dre));
            bn.close();
            if (dre) {
                return;
            }
        }
        if (akVar.drX().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            drW.a(id, dsf(), drW.Pe(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            drW.D(id, dsf(), false);
            kVar.g(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.drV().dsV());
        drW.a(id, dsf(), drW.Pe(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.lWS.c(a2, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bn;
                boolean IP = IP(i);
                if (aVar == null) {
                    if (IP) {
                        dsh().g(null, i);
                    }
                } else if (aVar.get().isStateful() || dB(i, 8)) {
                    dsh().g(aVar, i);
                } else {
                    if (!IP && (bn = h.this.lLL.bn(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dqQ = aVar.get().dqQ();
                            com.facebook.imagepipeline.g.h dqQ2 = bn.get().dqQ();
                            if (dqQ2.dre() || dqQ2.drc() >= dqQ.drc()) {
                                dsh().g(bn, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bn);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.lLL.a(bVar, aVar) : null;
                    if (IP) {
                        try {
                            dsh().aK(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dsh = dsh();
                    if (a != null) {
                        aVar = a;
                    }
                    dsh.g(aVar, i);
                }
            }
        };
    }

    protected String dsf() {
        return "BitmapMemoryCacheProducer";
    }
}
