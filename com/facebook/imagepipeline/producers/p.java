package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e mbD;
    private final com.facebook.imagepipeline.c.f mbE;
    private final com.facebook.imagepipeline.c.e mcH;
    private final aj<com.facebook.imagepipeline.g.e> meD;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mcH = eVar;
        this.mbD = eVar2;
        this.mbE = fVar;
        this.meD = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dtV().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.meD.c(akVar.dtT().drn() ? new a(kVar, akVar, this.mcH, this.mbD, this.mbE) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e mbD;
        private final com.facebook.imagepipeline.c.f mbE;
        private final com.facebook.imagepipeline.c.e mcH;
        private final ak meQ;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.meQ = akVar;
            this.mcH = eVar;
            this.mbD = eVar2;
            this.mbE = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Hs(i) || eVar == null || dm(i, 10) || eVar.dsV() == com.facebook.c.c.lYW) {
                duf().h(eVar, i);
                return;
            }
            ImageRequest dtT = this.meQ.dtT();
            com.facebook.cache.common.b c = this.mbE.c(dtT, this.meQ.dow());
            if (dtT.duK() == ImageRequest.CacheChoice.SMALL) {
                this.mbD.a(c, eVar);
            } else {
                this.mcH.a(c, eVar);
            }
            duf().h(eVar, i);
        }
    }
}
