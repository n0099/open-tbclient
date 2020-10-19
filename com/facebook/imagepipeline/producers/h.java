package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nLY;
    private final com.facebook.imagepipeline.c.f nUs;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nXr;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.nLY = pVar;
        this.nUs = fVar;
        this.nXr = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am edh = akVar.edh();
        String id = akVar.getId();
        edh.gH(id, edq());
        com.facebook.cache.common.b a2 = this.nUs.a(akVar.edg(), akVar.dXM());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bq = this.nLY.bq(a2);
        if (bq != null) {
            boolean ecq = bq.get().ecc().ecq();
            if (ecq) {
                edh.a(id, edq(), edh.VV(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                edh.F(id, edq(), true);
                kVar.aJ(1.0f);
            }
            kVar.h(bq, b.yV(ecq));
            bq.close();
            if (ecq) {
                return;
            }
        }
        if (akVar.edi().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            edh.a(id, edq(), edh.VV(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            edh.F(id, edq(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a3 = a(kVar, a2, akVar.edg().eef());
        edh.a(id, edq(), edh.VV(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.nXr.c(a3, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bq;
                boolean Nw = Nw(i);
                if (aVar == null) {
                    if (Nw) {
                        eds().h(null, i);
                    }
                } else if (aVar.get().isStateful() || dN(i, 8)) {
                    eds().h(aVar, i);
                } else {
                    if (!Nw && (bq = h.this.nLY.bq(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h ecc = aVar.get().ecc();
                            com.facebook.imagepipeline.g.h ecc2 = bq.get().ecc();
                            if (ecc2.ecq() || ecc2.eco() >= ecc.eco()) {
                                eds().h(bq, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bq);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a2 = z ? h.this.nLY.a(bVar, aVar) : null;
                    if (Nw) {
                        try {
                            eds().aJ(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a2);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> eds = eds();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    eds.h(aVar, i);
                }
            }
        };
    }

    protected String edq() {
        return "BitmapMemoryCacheProducer";
    }
}
