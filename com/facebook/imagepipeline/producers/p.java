package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e naT;
    private final com.facebook.imagepipeline.c.f naU;
    private final com.facebook.imagepipeline.c.e nbZ;
    private final aj<com.facebook.imagepipeline.g.e> ndV;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nbZ = eVar;
        this.naT = eVar2;
        this.naU = fVar;
        this.ndV = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dJr().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.ndV.c(akVar.dJp().dGK() ? new a(kVar, akVar, this.nbZ, this.naT, this.naU) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e naT;
        private final com.facebook.imagepipeline.c.f naU;
        private final com.facebook.imagepipeline.c.e nbZ;
        private final ak nei;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.nei = akVar;
            this.nbZ = eVar;
            this.naT = eVar2;
            this.naU = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (JI(i) || eVar == null || dC(i, 10) || eVar.dIs() == com.facebook.c.c.mYr) {
                dJB().h(eVar, i);
                return;
            }
            ImageRequest dJp = this.nei.dJp();
            com.facebook.cache.common.b c = this.naU.c(dJp, this.nei.dDU());
            if (dJp.dKg() == ImageRequest.CacheChoice.SMALL) {
                this.naT.a(c, eVar);
            } else {
                this.nbZ.a(c, eVar);
            }
            dJB().h(eVar, i);
        }
    }
}
