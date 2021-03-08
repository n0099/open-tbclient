package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class h implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pCX;
    private final com.facebook.imagepipeline.b.f pKU;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pNT;

    public h(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.pCX = pVar;
        this.pKU = fVar;
        this.pNT = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am ezz = akVar.ezz();
        String id = akVar.getId();
        ezz.hv(id, ezJ());
        com.facebook.cache.common.b a2 = this.pKU.a(akVar.ezy(), akVar.eum());
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bw = this.pCX.bw(a2);
        if (bw != null) {
            boolean eyL = bw.get().eyy().eyL();
            if (eyL) {
                ezz.b(id, ezJ(), ezz.ZM(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                ezz.M(id, ezJ(), true);
                kVar.be(1.0f);
            }
            kVar.f(bw, b.Br(eyL));
            bw.close();
            if (eyL) {
                return;
            }
        }
        if (akVar.ezA().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            ezz.b(id, ezJ(), ezz.ZM(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            ezz.M(id, ezJ(), false);
            kVar.f(null, 1);
            return;
        }
        k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a3 = a(kVar, a2, akVar.ezy().eAv());
        ezz.b(id, ezJ(), ezz.ZM(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.pNT.a(a3, akVar);
    }

    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, final com.facebook.cache.common.b bVar, final boolean z) {
        return new n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>(kVar) { // from class: com.facebook.imagepipeline.producers.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: a */
            public void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bw;
                boolean Qo = Qo(i);
                if (aVar == null) {
                    if (Qo) {
                        ezL().f(null, i);
                    }
                } else if (aVar.get().isStateful() || ed(i, 8)) {
                    ezL().f(aVar, i);
                } else {
                    if (!Qo && (bw = h.this.pCX.bw(bVar)) != null) {
                        try {
                            com.facebook.imagepipeline.f.h eyy = aVar.get().eyy();
                            com.facebook.imagepipeline.f.h eyy2 = bw.get().eyy();
                            if (eyy2.eyL() || eyy2.getQuality() >= eyy.getQuality()) {
                                ezL().f(bw, i);
                                return;
                            }
                        } finally {
                            com.facebook.common.references.a.c(bw);
                        }
                    }
                    com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = z ? h.this.pCX.a(bVar, aVar) : null;
                    if (Qo) {
                        try {
                            ezL().be(1.0f);
                        } finally {
                            com.facebook.common.references.a.c(a2);
                        }
                    }
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ezL = ezL();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    ezL.f(aVar, i);
                }
            }
        };
    }

    protected String ezJ() {
        return "BitmapMemoryCacheProducer";
    }
}
