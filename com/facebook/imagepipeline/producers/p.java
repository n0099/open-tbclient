package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e oWF;
    private final com.facebook.imagepipeline.c.f oWG;
    private final com.facebook.imagepipeline.c.e oXJ;
    private final aj<com.facebook.imagepipeline.g.e> oZF;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.oXJ = eVar;
        this.oWF = eVar2;
        this.oWG = fVar;
        this.oZF = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.eqV().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.oZF.c(akVar.eqT().eoo() ? new a(kVar, akVar, this.oXJ, this.oWF, this.oWG) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e oWF;
        private final com.facebook.imagepipeline.c.f oWG;
        private final com.facebook.imagepipeline.c.e oXJ;
        private final ak oZS;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.oZS = akVar;
            this.oXJ = eVar;
            this.oWF = eVar2;
            this.oWG = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Qm(i) || eVar == null || eb(i, 10) || eVar.epW() == com.facebook.c.c.oUd) {
                erf().h(eVar, i);
                return;
            }
            ImageRequest eqT = this.oZS.eqT();
            com.facebook.cache.common.b c = this.oWG.c(eqT, this.oZS.elx());
            if (eqT.erK() == ImageRequest.CacheChoice.SMALL) {
                this.oWF.a(c, eVar);
            } else {
                this.oXJ.a(c, eVar);
            }
            erf().h(eVar, i);
        }
    }
}
