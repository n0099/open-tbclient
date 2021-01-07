package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes3.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final com.facebook.imagepipeline.b.f pCH;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pFG;
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> puK;

    public ah(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.puK = pVar;
        this.pCH = fVar;
        this.pFG = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am eAI = akVar.eAI();
        String id = akVar.getId();
        ImageRequest eAH = akVar.eAH();
        Object evw = akVar.evw();
        com.facebook.imagepipeline.request.b eBF = eAH.eBF();
        if (eBF == null || eBF.eAG() == null) {
            this.pFG.a(kVar, akVar);
            return;
        }
        eAI.hn(id, eAS());
        com.facebook.cache.common.b b2 = this.pCH.b(eAH, evw);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.puK.bu(b2);
        if (bu != null) {
            eAI.b(id, eAS(), eAI.ZA(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            eAI.M(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aX(1.0f);
            kVar.g(bu, 1);
            bu.close();
            return;
        }
        a aVar = new a(kVar, b2, eBF instanceof com.facebook.imagepipeline.request.c, this.puK, akVar.eAH().eBE());
        eAI.b(id, eAS(), eAI.ZA(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.pFG.a(aVar, akVar);
    }

    /* loaded from: classes3.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final boolean pHa;
        private final boolean pHb;
        private final com.facebook.cache.common.b psK;
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> puK;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, boolean z2) {
            super(kVar);
            this.psK = bVar;
            this.pHa = z;
            this.puK = pVar;
            this.pHb = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (aVar == null) {
                if (Rv(i)) {
                    eAU().g(null, i);
                }
            } else if (!Rw(i) || this.pHa) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = this.pHb ? this.puK.a(this.psK, aVar) : null;
                try {
                    eAU().aX(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> eAU = eAU();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    eAU.g(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a2);
                }
            }
        }
    }

    protected String eAS() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
