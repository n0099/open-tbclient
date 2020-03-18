package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e lTQ;
    private final com.facebook.imagepipeline.c.f lTR;
    private final com.facebook.imagepipeline.c.e lUW;
    private final aj<com.facebook.imagepipeline.g.e> lWS;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lUW = eVar;
        this.lTQ = eVar2;
        this.lTR = fVar;
        this.lWS = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.drX().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.lWS.c(akVar.drV().dpp() ? new a(kVar, akVar, this.lUW, this.lTQ, this.lTR) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e lTQ;
        private final com.facebook.imagepipeline.c.f lTR;
        private final com.facebook.imagepipeline.c.e lUW;
        private final ak lXf;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.lXf = akVar;
            this.lUW = eVar;
            this.lTQ = eVar2;
            this.lTR = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (IQ(i) || eVar == null || dC(i, 10) || eVar.dqX() == com.facebook.c.c.lRr) {
                dsh().g(eVar, i);
                return;
            }
            ImageRequest drV = this.lXf.drV();
            com.facebook.cache.common.b c = this.lTR.c(drV, this.lXf.dmD());
            if (drV.dsN() == ImageRequest.CacheChoice.SMALL) {
                this.lTQ.a(c, eVar);
            } else {
                this.lUW.a(c, eVar);
            }
            dsh().g(eVar, i);
        }
    }
}
