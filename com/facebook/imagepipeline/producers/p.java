package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class p implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.e pAZ;
    private final com.facebook.imagepipeline.b.f pBa;
    private final com.facebook.imagepipeline.b.e pCd;
    private final aj<com.facebook.imagepipeline.f.e> pDZ;

    public p(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pCd = eVar;
        this.pAZ = eVar2;
        this.pBa = fVar;
        this.pDZ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        c(kVar, akVar);
    }

    private void c(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.eAf().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.pDZ.a(akVar.eAd().exD() ? new a(kVar, akVar, this.pCd, this.pAZ, this.pBa) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.b.e pAZ;
        private final com.facebook.imagepipeline.b.f pBa;
        private final com.facebook.imagepipeline.b.e pCd;
        private final ak pEm;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar) {
            super(kVar);
            this.pEm = akVar;
            this.pCd = eVar;
            this.pAZ = eVar2;
            this.pBa = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (Rg(i) || eVar == null || ee(i, 10) || eVar.ezj() == com.facebook.c.c.pzf) {
                eAq().g(eVar, i);
                return;
            }
            ImageRequest eAd = this.pEm.eAd();
            com.facebook.cache.common.b c = this.pBa.c(eAd, this.pEm.evp());
            if (eAd.eAS() == ImageRequest.CacheChoice.SMALL) {
                this.pAZ.a(c, eVar);
            } else {
                this.pCd.a(c, eVar);
            }
            eAq().g(eVar, i);
        }
    }
}
