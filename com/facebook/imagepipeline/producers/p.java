package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e naR;
    private final com.facebook.imagepipeline.c.f naS;
    private final com.facebook.imagepipeline.c.e nbX;
    private final aj<com.facebook.imagepipeline.g.e> ndT;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nbX = eVar;
        this.naR = eVar2;
        this.naS = fVar;
        this.ndT = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dJq().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.ndT.c(akVar.dJo().dGJ() ? new a(kVar, akVar, this.nbX, this.naR, this.naS) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e naR;
        private final com.facebook.imagepipeline.c.f naS;
        private final com.facebook.imagepipeline.c.e nbX;
        private final ak neg;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.neg = akVar;
            this.nbX = eVar;
            this.naR = eVar2;
            this.naS = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (JI(i) || eVar == null || dC(i, 10) || eVar.dIr() == com.facebook.c.c.mYp) {
                dJA().h(eVar, i);
                return;
            }
            ImageRequest dJo = this.neg.dJo();
            com.facebook.cache.common.b c = this.naS.c(dJo, this.neg.dDT());
            if (dJo.dKf() == ImageRequest.CacheChoice.SMALL) {
                this.naR.a(c, eVar);
            } else {
                this.nbX.a(c, eVar);
            }
            dJA().h(eVar, i);
        }
    }
}
