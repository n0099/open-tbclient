package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes3.dex */
public class p implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.e pCG;
    private final com.facebook.imagepipeline.b.f pCH;
    private final com.facebook.imagepipeline.b.e pDK;
    private final aj<com.facebook.imagepipeline.f.e> pFG;

    public p(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pDK = eVar;
        this.pCG = eVar2;
        this.pCH = fVar;
        this.pFG = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        c(kVar, akVar);
    }

    private void c(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.eAJ().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.pFG.a(akVar.eAH().eyf() ? new a(kVar, akVar, this.pDK, this.pCG, this.pCH) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.b.e pCG;
        private final com.facebook.imagepipeline.b.f pCH;
        private final com.facebook.imagepipeline.b.e pDK;
        private final ak pFT;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar) {
            super(kVar);
            this.pFT = akVar;
            this.pDK = eVar;
            this.pCG = eVar2;
            this.pCH = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (Rw(i) || eVar == null || eg(i, 10) || eVar.ezN() == com.facebook.c.c.pAq) {
                eAU().g(eVar, i);
                return;
            }
            ImageRequest eAH = this.pFT.eAH();
            com.facebook.cache.common.b c = this.pCH.c(eAH, this.pFT.evw());
            if (eAH.eBw() == ImageRequest.CacheChoice.SMALL) {
                this.pCG.a(c, eVar);
            } else {
                this.pDK.a(c, eVar);
            }
            eAU().g(eVar, i);
        }
    }
}
