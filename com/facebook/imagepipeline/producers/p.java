package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e mbH;
    private final com.facebook.imagepipeline.c.f mbI;
    private final com.facebook.imagepipeline.c.e mcL;
    private final aj<com.facebook.imagepipeline.g.e> meH;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mcL = eVar;
        this.mbH = eVar2;
        this.mbI = fVar;
        this.meH = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dtS().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.meH.c(akVar.dtQ().drk() ? new a(kVar, akVar, this.mcL, this.mbH, this.mbI) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e mbH;
        private final com.facebook.imagepipeline.c.f mbI;
        private final com.facebook.imagepipeline.c.e mcL;
        private final ak meU;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.meU = akVar;
            this.mcL = eVar;
            this.mbH = eVar2;
            this.mbI = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Hs(i) || eVar == null || dm(i, 10) || eVar.dsS() == com.facebook.c.c.lZa) {
                duc().h(eVar, i);
                return;
            }
            ImageRequest dtQ = this.meU.dtQ();
            com.facebook.cache.common.b c = this.mbI.c(dtQ, this.meU.dot());
            if (dtQ.duH() == ImageRequest.CacheChoice.SMALL) {
                this.mbH.a(c, eVar);
            } else {
                this.mcL.a(c, eVar);
            }
            duc().h(eVar, i);
        }
    }
}
