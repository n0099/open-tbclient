package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e mvy;
    private final com.facebook.imagepipeline.c.f mvz;
    private final com.facebook.imagepipeline.c.e mwC;
    private final aj<com.facebook.imagepipeline.g.e> myy;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mwC = eVar;
        this.mvy = eVar2;
        this.mvz = fVar;
        this.myy = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dBk().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.myy.c(akVar.dBi().dyD() ? new a(kVar, akVar, this.mwC, this.mvy, this.mvz) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e mvy;
        private final com.facebook.imagepipeline.c.f mvz;
        private final com.facebook.imagepipeline.c.e mwC;
        private final ak myL;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.myL = akVar;
            this.mwC = eVar;
            this.mvy = eVar2;
            this.mvz = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Ie(i) || eVar == null || dr(i, 10) || eVar.dAl() == com.facebook.c.c.msV) {
                dBu().h(eVar, i);
                return;
            }
            ImageRequest dBi = this.myL.dBi();
            com.facebook.cache.common.b c = this.mvz.c(dBi, this.myL.dvM());
            if (dBi.dBZ() == ImageRequest.CacheChoice.SMALL) {
                this.mvy.a(c, eVar);
            } else {
                this.mwC.a(c, eVar);
            }
            dBu().h(eVar, i);
        }
    }
}
