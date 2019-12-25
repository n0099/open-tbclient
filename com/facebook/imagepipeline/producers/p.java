package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes9.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.f lNA;
    private final com.facebook.imagepipeline.c.e lNz;
    private final com.facebook.imagepipeline.c.e lOF;
    private final aj<com.facebook.imagepipeline.g.e> lQz;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lOF = eVar;
        this.lNz = eVar2;
        this.lNA = fVar;
        this.lQz = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.doZ().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.lQz.c(akVar.doX().dmu() ? new a(kVar, akVar, this.lOF, this.lNz, this.lNA) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.f lNA;
        private final com.facebook.imagepipeline.c.e lNz;
        private final com.facebook.imagepipeline.c.e lOF;
        private final ak lQM;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.lQM = akVar;
            this.lOF = eVar;
            this.lNz = eVar2;
            this.lNA = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Iw(i) || eVar == null || dA(i, 10) || eVar.dod() == com.facebook.c.c.lLb) {
                dpj().g(eVar, i);
                return;
            }
            ImageRequest doX = this.lQM.doX();
            com.facebook.cache.common.b c = this.lNA.c(doX, this.lQM.djN());
            if (doX.dpM() == ImageRequest.CacheChoice.SMALL) {
                this.lNz.a(c, eVar);
            } else {
                this.lOF.a(c, eVar);
            }
            dpj().g(eVar, i);
        }
    }
}
