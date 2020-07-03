package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e mSJ;
    private final com.facebook.imagepipeline.c.f mSK;
    private final com.facebook.imagepipeline.c.e mTS;
    private final aj<com.facebook.imagepipeline.g.e> mVP;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mTS = eVar;
        this.mSJ = eVar2;
        this.mSK = fVar;
        this.mVP = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dGa().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.mVP.c(akVar.dFY().dDt() ? new a(kVar, akVar, this.mTS, this.mSJ, this.mSK) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e mSJ;
        private final com.facebook.imagepipeline.c.f mSK;
        private final com.facebook.imagepipeline.c.e mTS;
        private final ak mWc;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.mWc = akVar;
            this.mTS = eVar;
            this.mSJ = eVar2;
            this.mSK = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Jn(i) || eVar == null || dA(i, 10) || eVar.dFb() == com.facebook.c.c.mQe) {
                dGk().h(eVar, i);
                return;
            }
            ImageRequest dFY = this.mWc.dFY();
            com.facebook.cache.common.b c = this.mSK.c(dFY, this.mWc.dAD());
            if (dFY.dGP() == ImageRequest.CacheChoice.SMALL) {
                this.mSJ.a(c, eVar);
            } else {
                this.mTS.a(c, eVar);
            }
            dGk().h(eVar, i);
        }
    }
}
