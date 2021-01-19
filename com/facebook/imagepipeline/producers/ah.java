package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes3.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pBg;
    private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pqj;
    private final com.facebook.imagepipeline.b.f pyh;

    public ah(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        this.pqj = pVar;
        this.pyh = fVar;
        this.pBg = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        am ewQ = akVar.ewQ();
        String id = akVar.getId();
        ImageRequest ewP = akVar.ewP();
        Object erD = akVar.erD();
        com.facebook.imagepipeline.request.b exN = ewP.exN();
        if (exN == null || exN.ewO() == null) {
            this.pBg.a(kVar, akVar);
            return;
        }
        ewQ.hm(id, exa());
        com.facebook.cache.common.b b2 = this.pyh.b(ewP, erD);
        com.facebook.common.references.a<com.facebook.imagepipeline.f.c> bu = this.pqj.bu(b2);
        if (bu != null) {
            ewQ.b(id, exa(), ewQ.Yt(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            ewQ.M(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aX(1.0f);
            kVar.g(bu, 1);
            bu.close();
            return;
        }
        a aVar = new a(kVar, b2, exN instanceof com.facebook.imagepipeline.request.c, this.pqj, akVar.ewP().exM());
        ewQ.b(id, exa(), ewQ.Yt(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.pBg.a(aVar, akVar);
    }

    /* loaded from: classes3.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final boolean pCA;
        private final boolean pCB;
        private final com.facebook.cache.common.b pog;
        private final com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pqj;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, boolean z2) {
            super(kVar);
            this.pog = bVar;
            this.pCA = z;
            this.pqj = pVar;
            this.pCB = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            if (aVar == null) {
                if (PO(i)) {
                    exc().g(null, i);
                }
            } else if (!PP(i) || this.pCA) {
                com.facebook.common.references.a<com.facebook.imagepipeline.f.c> a2 = this.pCB ? this.pqj.a(this.pog, aVar) : null;
                try {
                    exc().aX(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> exc = exc();
                    if (a2 != null) {
                        aVar = a2;
                    }
                    exc.g(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a2);
                }
            }
        }
    }

    protected String exa() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
