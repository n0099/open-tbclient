package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mSu;
    private final com.facebook.imagepipeline.c.f naU;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ndV;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.mSu = pVar;
        this.naU = fVar;
        this.ndV = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dJq = akVar.dJq();
        String id = akVar.getId();
        dJq.fW(id, dJz());
        com.facebook.cache.common.b a = this.naU.a(akVar.dJp(), akVar.dDU());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bj = this.mSu.bj(a);
        if (bj != null) {
            boolean dIz = bj.get().dIl().dIz();
            if (dIz) {
                dJq.a(id, dJz(), dJq.RB(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dJq.G(id, dJz(), true);
                kVar.ax(1.0f);
            }
            kVar.h(bj, b.xm(dIz));
            bj.close();
            if (dIz) {
                return;
            }
        }
        if (akVar.dJr().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            dJq.a(id, dJz(), dJq.RB(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            dJq.G(id, dJz(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.dJp().dKo());
        dJq.a(id, dJz(), dJq.RB(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.ndV.c(a2, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bj;
                boolean JH = JH(i);
                if (aVar == null) {
                    if (JH) {
                        dJB().h(null, i);
                    }
                } else if (aVar.get().isStateful() || dB(i, 8)) {
                    dJB().h(aVar, i);
                } else {
                    if (!JH && (bj = h.this.mSu.bj(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dIl = aVar.get().dIl();
                            com.facebook.imagepipeline.g.h dIl2 = bj.get().dIl();
                            if (dIl2.dIz() || dIl2.dIx() >= dIl.dIx()) {
                                dJB().h(bj, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bj);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.mSu.a(bVar, aVar) : null;
                    if (JH) {
                        try {
                            dJB().ax(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dJB = dJB();
                    if (a != null) {
                        aVar = a;
                    }
                    dJB.h(aVar, i);
                }
            }
        };
    }

    protected String dJz() {
        return "BitmapMemoryCacheProducer";
    }
}
