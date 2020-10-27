package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> oDr;
    private final com.facebook.imagepipeline.c.f oLK;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oOJ;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.oDr = pVar;
        this.oLK = fVar;
        this.oOJ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am eng = akVar.eng();
        String id = akVar.getId();
        eng.gX(id, enp());
        com.facebook.cache.common.b a2 = this.oLK.a(akVar.enf(), akVar.ehK());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bu = this.oDr.bu(a2);
        if (bu != null) {
            boolean emo = bu.get().ema().emo();
            if (emo) {
                eng.a(id, enp(), eng.XI(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                eng.G(id, enp(), true);
                kVar.aL(1.0f);
            }
            kVar.h(bu, b.Ad(emo));
            bu.close();
            if (emo) {
                return;
            }
        }
        if (akVar.enh().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            eng.a(id, enp(), eng.XI(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            eng.G(id, enp(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a3 = a(kVar, a2, akVar.enf().eoe());
        eng.a(id, enp(), eng.XI(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.oOJ.c(a3, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bu;
                boolean Pn = Pn(i);
                if (aVar == null) {
                    if (Pn) {
                        enr().h(null, i);
                    }
                } else if (aVar.get().isStateful() || dW(i, 8)) {
                    enr().h(aVar, i);
                } else {
                    if (!Pn && (bu = h.this.oDr.bu(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h ema = aVar.get().ema();
                            com.facebook.imagepipeline.g.h ema2 = bu.get().ema();
                            if (ema2.emo() || ema2.emm() >= ema.emm()) {
                                enr().h(bu, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bu);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a2 = z ? h.this.oDr.a(bVar, aVar) : null;
                    if (Pn) {
                        try {
                            enr().aL(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a2);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> enr = enr();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    enr.h(aVar, i);
                }
            }
        };
    }

    protected String enp() {
        return "BitmapMemoryCacheProducer";
    }
}
