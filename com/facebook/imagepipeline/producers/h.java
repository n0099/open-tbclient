package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> mSs;
    private final com.facebook.imagepipeline.c.f naS;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ndT;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.mSs = pVar;
        this.naS = fVar;
        this.ndT = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dJp = akVar.dJp();
        String id = akVar.getId();
        dJp.fW(id, dJy());
        com.facebook.cache.common.b a = this.naS.a(akVar.dJo(), akVar.dDT());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bj = this.mSs.bj(a);
        if (bj != null) {
            boolean dIy = bj.get().dIk().dIy();
            if (dIy) {
                dJp.a(id, dJy(), dJp.RB(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dJp.G(id, dJy(), true);
                kVar.ax(1.0f);
            }
            kVar.h(bj, b.xm(dIy));
            bj.close();
            if (dIy) {
                return;
            }
        }
        if (akVar.dJq().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            dJp.a(id, dJy(), dJp.RB(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            dJp.G(id, dJy(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.dJo().dKn());
        dJp.a(id, dJy(), dJp.RB(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.ndT.c(a2, akVar);
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
                        dJA().h(null, i);
                    }
                } else if (aVar.get().isStateful() || dB(i, 8)) {
                    dJA().h(aVar, i);
                } else {
                    if (!JH && (bj = h.this.mSs.bj(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dIk = aVar.get().dIk();
                            com.facebook.imagepipeline.g.h dIk2 = bj.get().dIk();
                            if (dIk2.dIy() || dIk2.dIw() >= dIk.dIw()) {
                                dJA().h(bj, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bj);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.mSs.a(bVar, aVar) : null;
                    if (JH) {
                        try {
                            dJA().ax(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dJA = dJA();
                    if (a != null) {
                        aVar = a;
                    }
                    dJA.h(aVar, i);
                }
            }
        };
    }

    protected String dJy() {
        return "BitmapMemoryCacheProducer";
    }
}
