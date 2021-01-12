package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes3.dex */
public class p implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> pBf;
    private final com.facebook.imagepipeline.b.e pyf;
    private final com.facebook.imagepipeline.b.f pyg;
    private final com.facebook.imagepipeline.b.e pzj;

    public p(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pzj = eVar;
        this.pyf = eVar2;
        this.pyg = fVar;
        this.pBf = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        c(kVar, akVar);
    }

    private void c(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.ewR().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.pBf.a(akVar.ewP().eun() ? new a(kVar, akVar, this.pzj, this.pyf, this.pyg) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final ak pBs;
        private final com.facebook.imagepipeline.b.e pyf;
        private final com.facebook.imagepipeline.b.f pyg;
        private final com.facebook.imagepipeline.b.e pzj;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar) {
            super(kVar);
            this.pBs = akVar;
            this.pzj = eVar;
            this.pyf = eVar2;
            this.pyg = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (PP(i) || eVar == null || eg(i, 10) || eVar.evV() == com.facebook.c.c.pvP) {
                exc().g(eVar, i);
                return;
            }
            ImageRequest ewP = this.pBs.ewP();
            com.facebook.cache.common.b c = this.pyg.c(ewP, this.pBs.erD());
            if (ewP.exE() == ImageRequest.CacheChoice.SMALL) {
                this.pyf.a(c, eVar);
            } else {
                this.pzj.a(c, eVar);
            }
            exc().g(eVar, i);
        }
    }
}
