package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e lRX;
    private final com.facebook.imagepipeline.c.f lRY;
    private final com.facebook.imagepipeline.c.e lTd;
    private final aj<com.facebook.imagepipeline.g.e> lUZ;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lTd = eVar;
        this.lRX = eVar2;
        this.lRY = fVar;
        this.lUZ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.drx().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.lUZ.c(akVar.drv().doP() ? new a(kVar, akVar, this.lTd, this.lRX, this.lRY) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e lRX;
        private final com.facebook.imagepipeline.c.f lRY;
        private final com.facebook.imagepipeline.c.e lTd;
        private final ak lVm;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.lVm = akVar;
            this.lTd = eVar;
            this.lRX = eVar2;
            this.lRY = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (IK(i) || eVar == null || dB(i, 10) || eVar.dqx() == com.facebook.c.c.lPy) {
                drH().g(eVar, i);
                return;
            }
            ImageRequest drv = this.lVm.drv();
            com.facebook.cache.common.b c = this.lRY.c(drv, this.lVm.dmd());
            if (drv.dsn() == ImageRequest.CacheChoice.SMALL) {
                this.lRX.a(c, eVar);
            } else {
                this.lTd.a(c, eVar);
            }
            drH().g(eVar, i);
        }
    }
}
