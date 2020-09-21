package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes25.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.f nEZ;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nIa;
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> nwF;

    public h(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.nwF = pVar;
        this.nEZ = fVar;
        this.nIa = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am dZw = akVar.dZw();
        String id = akVar.getId();
        dZw.gA(id, dZF());
        com.facebook.cache.common.b a = this.nEZ.a(akVar.dZv(), akVar.dUb());
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bn = this.nwF.bn(a);
        if (bn != null) {
            boolean dYF = bn.get().dYr().dYF();
            if (dYF) {
                dZw.a(id, dZF(), dZw.Vh(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                dZw.F(id, dZF(), true);
                kVar.aD(1.0f);
            }
            kVar.h(bn, b.yo(dYF));
            bn.close();
            if (dYF) {
                return;
            }
        }
        if (akVar.dZx().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            dZw.a(id, dZF(), dZw.Vh(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            dZw.F(id, dZF(), false);
            kVar.h(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a2 = a(kVar, a, akVar.dZv().eau());
        dZw.a(id, dZF(), dZw.Vh(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.nIa.c(a2, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bn;
                boolean MQ = MQ(i);
                if (aVar == null) {
                    if (MQ) {
                        dZH().h(null, i);
                    }
                } else if (aVar.get().isStateful() || dN(i, 8)) {
                    dZH().h(aVar, i);
                } else {
                    if (!MQ && (bn = h.this.nwF.bn(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.g.h dYr = aVar.get().dYr();
                            com.facebook.imagepipeline.g.h dYr2 = bn.get().dYr();
                            if (dYr2.dYF() || dYr2.dYD() >= dYr.dYD()) {
                                dZH().h(bn, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bn);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = z ? h.this.nwF.a(bVar, aVar) : null;
                    if (MQ) {
                        try {
                            dZH().aD(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dZH = dZH();
                    if (a != null) {
                        aVar = a;
                    }
                    dZH.h(aVar, i);
                }
            }
        };
    }

    protected String dZF() {
        return "BitmapMemoryCacheProducer";
    }
}
