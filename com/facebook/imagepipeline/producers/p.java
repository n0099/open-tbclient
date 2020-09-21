package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes25.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e nEY;
    private final com.facebook.imagepipeline.c.f nEZ;
    private final com.facebook.imagepipeline.c.e nGe;
    private final aj<com.facebook.imagepipeline.g.e> nIa;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nGe = eVar;
        this.nEY = eVar2;
        this.nEZ = fVar;
        this.nIa = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dZx().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.nIa.c(akVar.dZv().dWQ() ? new a(kVar, akVar, this.nGe, this.nEY, this.nEZ) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e nEY;
        private final com.facebook.imagepipeline.c.f nEZ;
        private final com.facebook.imagepipeline.c.e nGe;
        private final ak nIn;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.nIn = akVar;
            this.nGe = eVar;
            this.nEY = eVar2;
            this.nEZ = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (MR(i) || eVar == null || dO(i, 10) || eVar.dYy() == com.facebook.c.c.nCw) {
                dZH().h(eVar, i);
                return;
            }
            ImageRequest dZv = this.nIn.dZv();
            com.facebook.cache.common.b c = this.nEZ.c(dZv, this.nIn.dUb());
            if (dZv.eam() == ImageRequest.CacheChoice.SMALL) {
                this.nEY.a(c, eVar);
            } else {
                this.nGe.a(c, eVar);
            }
            dZH().h(eVar, i);
        }
    }
}
