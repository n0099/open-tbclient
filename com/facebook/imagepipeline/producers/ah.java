package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes9.dex */
public class ah implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lFI;
    private final com.facebook.imagepipeline.c.f lNA;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lQz;

    public ah(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        this.lFI = pVar;
        this.lNA = fVar;
        this.lQz = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        am doY = akVar.doY();
        String id = akVar.getId();
        ImageRequest doX = akVar.doX();
        Object djN = akVar.djN();
        com.facebook.imagepipeline.request.a dpW = doX.dpW();
        if (dpW == null || dpW.dqa() == null) {
            this.lQz.c(kVar, akVar);
            return;
        }
        doY.fc(id, dph());
        com.facebook.cache.common.b b = this.lNA.b(doX, djN);
        com.facebook.common.references.a<com.facebook.imagepipeline.g.c> bk = this.lFI.bk(b);
        if (bk != null) {
            doY.a(id, dph(), doY.OF(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            doY.C(id, "PostprocessedBitmapMemoryCacheProducer", true);
            kVar.aM(1.0f);
            kVar.g(bk, 1);
            bk.close();
            return;
        }
        a aVar = new a(kVar, b, dpW instanceof com.facebook.imagepipeline.request.b, this.lFI, akVar.doX().dpU());
        doY.a(id, dph(), doY.OF(id) ? ImmutableMap.of("cached_value_found", "false") : null);
        this.lQz.c(aVar, akVar);
    }

    /* loaded from: classes9.dex */
    public static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final com.facebook.cache.common.b lDH;
        private final com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> lFI;
        private final boolean lRS;
        private final boolean lRT;

        public a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z, com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, boolean z2) {
            super(kVar);
            this.lDH = bVar;
            this.lRS = z;
            this.lFI = pVar;
            this.lRT = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            if (aVar == null) {
                if (Iv(i)) {
                    dpj().g(null, i);
                }
            } else if (!Iw(i) || this.lRS) {
                com.facebook.common.references.a<com.facebook.imagepipeline.g.c> a = this.lRT ? this.lFI.a(this.lDH, aVar) : null;
                try {
                    dpj().aM(1.0f);
                    k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> dpj = dpj();
                    if (a != null) {
                        aVar = a;
                    }
                    dpj.g(aVar, i);
                } finally {
                    com.facebook.common.references.a.c(a);
                }
            }
        }
    }

    protected String dph() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
