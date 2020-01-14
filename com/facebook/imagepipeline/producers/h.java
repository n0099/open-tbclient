package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes10.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJl;
    private final com.facebook.imagepipeline.c.f lRr;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lUs;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lJl = pVar;
        this.lRr = fVar;
        this.lUs = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dqk = akVar.dqk();
        String id = akVar.getId();
        dqk.fe(id, dqt());
        com.facebook.cache.common.b a = this.lRr.a(akVar.dqj(), akVar.dkQ());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bl = this.lJl.bl(a);
        if (bl != null) {
            boolean dps = bl.get().dpe().dps();
            if (dps) {
                dqk.a(id, dqt(), dqk.OQ(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dqk.C(id, dqt(), true);
                kVar.aL(1.0f);
            }
            kVar.g(bl, b.vn(dps));
            bl.close();
            if (dps) {
                return;
            }
        }
        if (akVar.dql().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            dqk.a(id, dqt(), dqk.OQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            dqk.C(id, dqt(), false);
            kVar.g(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.dqj().drj());
        dqk.a(id, dqt(), dqk.OQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.lUs.c(a2, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bl;
                boolean IE = IE(i);
                if (aVar == null) {
                    if (IE) {
                        dqv().g(null, i);
                    }
                } else if (aVar.get().isStateful() || dx(i, 8)) {
                    dqv().g(aVar, i);
                } else {
                    if (!IE && (bl = h.this.lJl.bl(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dpe = aVar.get().dpe();
                            com.facebook.imagepipeline.g.h dpe2 = bl.get().dpe();
                            if (dpe2.dps() || dpe2.dpq() >= dpe.dpq()) {
                                dqv().g(bl, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bl);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.lJl.a(bVar, aVar) : null;
                    if (IE) {
                        try {
                            dqv().aL(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqv = dqv();
                    if (a != null) {
                        aVar = a;
                    }
                    dqv.g(aVar, i);
                }
            }
        };
    }

    protected String dqt() {
        return "BitmapMemoryCacheProducer";
    }
}
