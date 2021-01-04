package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final com.facebook.imagepipeline.b.f pBa;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pDZ;
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> puD;

    public ah(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.puD = pVar;
        this.pBa = fVar;
        this.pDZ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am eAe = akVar.eAe();
        String id = akVar.getId();
        ImageRequest eAd = akVar.eAd();
        Object evp = akVar.evp();
        com.facebook.imagepipeline.request.b eBb = eAd.eBb();
        if (eBb == null || eBb.eAc() == null) {
            this.pDZ.a(kVar, akVar);
            return;
        }
        eAe.hm(id, eAo());
        com.facebook.cache.common.b b2 = this.pBa.b(eAd, evp);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.puD.bu(b2);
        if (bu != null) {
            eAe.b(id, eAo(), eAe.ZA(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            eAe.M(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aX(1.0f);
            kVar.g(bu, 1);
            bu.close();
            return;
        }
        a aVar = new a(kVar, b2, eBb instanceof com.facebook.imagepipeline.request.c, this.puD, akVar.eAd().eBa());
        eAe.b(id, eAo(), eAe.ZA(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.pDZ.a(aVar, akVar);
    }

    /* loaded from: classes5.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final boolean pFt;
        private final boolean pFu;
        private final com.facebook.cache.common.b psJ;
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> puD;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, boolean z2) {
            super(kVar);
            this.psJ = bVar;
            this.pFt = z;
            this.puD = pVar;
            this.pFu = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (aVar == null) {
                if (Rf(i)) {
                    eAq().g(null, i);
                }
            } else if (!Rg(i) || this.pFt) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = this.pFu ? this.puD.a(this.psJ, aVar) : null;
                try {
                    eAq().aX(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eAq = eAq();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    eAq.g(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a2);
                }
            }
        }
    }

    protected String eAo() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
