package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes10.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lJg;
    private final com.facebook.imagepipeline.c.f lRm;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lUn;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lJg = pVar;
        this.lRm = fVar;
        this.lUn = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dqi = akVar.dqi();
        String id = akVar.getId();
        dqi.fe(id, dqr());
        com.facebook.cache.common.b a = this.lRm.a(akVar.dqh(), akVar.dkO());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bl = this.lJg.bl(a);
        if (bl != null) {
            boolean dpq = bl.get().dpc().dpq();
            if (dpq) {
                dqi.a(id, dqr(), dqi.OQ(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dqi.C(id, dqr(), true);
                kVar.aL(1.0f);
            }
            kVar.g(bl, b.vn(dpq));
            bl.close();
            if (dpq) {
                return;
            }
        }
        if (akVar.dqj().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            dqi.a(id, dqr(), dqi.OQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            dqi.C(id, dqr(), false);
            kVar.g(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.dqh().drh());
        dqi.a(id, dqr(), dqi.OQ(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.lUn.c(a2, akVar);
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
                        dqt().g(null, i);
                    }
                } else if (aVar.get().isStateful() || dx(i, 8)) {
                    dqt().g(aVar, i);
                } else {
                    if (!IE && (bl = h.this.lJg.bl(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dpc = aVar.get().dpc();
                            com.facebook.imagepipeline.g.h dpc2 = bl.get().dpc();
                            if (dpc2.dpq() || dpc2.dpo() >= dpc.dpo()) {
                                dqt().g(bl, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bl);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.lJg.a(bVar, aVar) : null;
                    if (IE) {
                        try {
                            dqt().aL(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dqt = dqt();
                    if (a != null) {
                        aVar = a;
                    }
                    dqt.g(aVar, i);
                }
            }
        };
    }

    protected String dqr() {
        return "BitmapMemoryCacheProducer";
    }
}
