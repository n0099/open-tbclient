package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e mSM;
    private final com.facebook.imagepipeline.c.f mSN;
    private final com.facebook.imagepipeline.c.e mTV;
    private final aj<com.facebook.imagepipeline.g.e> mVS;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mTV = eVar;
        this.mSM = eVar2;
        this.mSN = fVar;
        this.mVS = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dGe().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.mVS.c(akVar.dGc().dDx() ? new a(kVar, akVar, this.mTV, this.mSM, this.mSN) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e mSM;
        private final com.facebook.imagepipeline.c.f mSN;
        private final com.facebook.imagepipeline.c.e mTV;
        private final ak mWf;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.mWf = akVar;
            this.mTV = eVar;
            this.mSM = eVar2;
            this.mSN = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Jn(i) || eVar == null || dA(i, 10) || eVar.dFf() == com.facebook.c.c.mQh) {
                dGo().h(eVar, i);
                return;
            }
            ImageRequest dGc = this.mWf.dGc();
            com.facebook.cache.common.b c = this.mSN.c(dGc, this.mWf.dAH());
            if (dGc.dGT() == ImageRequest.CacheChoice.SMALL) {
                this.mSM.a(c, eVar);
            } else {
                this.mTV.a(c, eVar);
            }
            dGo().h(eVar, i);
        }
    }
}
