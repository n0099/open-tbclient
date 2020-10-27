package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e oLJ;
    private final com.facebook.imagepipeline.c.f oLK;
    private final com.facebook.imagepipeline.c.e oMN;
    private final aj<com.facebook.imagepipeline.g.e> oOJ;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.oMN = eVar;
        this.oLJ = eVar2;
        this.oLK = fVar;
        this.oOJ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.enh().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.oOJ.c(akVar.enf().ekz() ? new a(kVar, akVar, this.oMN, this.oLJ, this.oLK) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e oLJ;
        private final com.facebook.imagepipeline.c.f oLK;
        private final com.facebook.imagepipeline.c.e oMN;
        private final ak oOW;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.oOW = akVar;
            this.oMN = eVar;
            this.oLJ = eVar2;
            this.oLK = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Po(i) || eVar == null || dX(i, 10) || eVar.emh() == com.facebook.c.c.oJh) {
                enr().h(eVar, i);
                return;
            }
            ImageRequest enf = this.oOW.enf();
            com.facebook.cache.common.b c = this.oLK.c(enf, this.oOW.ehK());
            if (enf.enW() == ImageRequest.CacheChoice.SMALL) {
                this.oLJ.a(c, eVar);
            } else {
                this.oMN.a(c, eVar);
            }
            enr().h(eVar, i);
        }
    }
}
