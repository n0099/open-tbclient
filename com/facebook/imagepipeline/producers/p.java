package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e oVc;
    private final com.facebook.imagepipeline.c.f oVd;
    private final com.facebook.imagepipeline.c.e oWg;
    private final aj<com.facebook.imagepipeline.g.e> oYc;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.oWg = eVar;
        this.oVc = eVar2;
        this.oVd = fVar;
        this.oYc = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.eqX().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.oYc.c(akVar.eqV().eoq() ? new a(kVar, akVar, this.oWg, this.oVc, this.oVd) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e oVc;
        private final com.facebook.imagepipeline.c.f oVd;
        private final com.facebook.imagepipeline.c.e oWg;
        private final ak oYp;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.oYp = akVar;
            this.oWg = eVar;
            this.oVc = eVar2;
            this.oVd = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (PJ(i) || eVar == null || ea(i, 10) || eVar.epY() == com.facebook.c.c.oSA) {
                erh().h(eVar, i);
                return;
            }
            ImageRequest eqV = this.oYp.eqV();
            com.facebook.cache.common.b c = this.oVd.c(eqV, this.oYp.elz());
            if (eqV.erM() == ImageRequest.CacheChoice.SMALL) {
                this.oVc.a(c, eVar);
            } else {
                this.oWg.a(c, eVar);
            }
            erh().h(eVar, i);
        }
    }
}
