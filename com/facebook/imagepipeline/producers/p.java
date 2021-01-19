package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes3.dex */
public class p implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> pBg;
    private final com.facebook.imagepipeline.b.e pyg;
    private final com.facebook.imagepipeline.b.f pyh;
    private final com.facebook.imagepipeline.b.e pzk;

    public p(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pzk = eVar;
        this.pyg = eVar2;
        this.pyh = fVar;
        this.pBg = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        c(kVar, akVar);
    }

    private void c(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.ewR().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.pBg.a(akVar.ewP().eun() ? new a(kVar, akVar, this.pzk, this.pyg, this.pyh) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final ak pBt;
        private final com.facebook.imagepipeline.b.e pyg;
        private final com.facebook.imagepipeline.b.f pyh;
        private final com.facebook.imagepipeline.b.e pzk;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar) {
            super(kVar);
            this.pBt = akVar;
            this.pzk = eVar;
            this.pyg = eVar2;
            this.pyh = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (PP(i) || eVar == null || eg(i, 10) || eVar.evV() == com.facebook.c.c.pvQ) {
                exc().g(eVar, i);
                return;
            }
            ImageRequest ewP = this.pBt.ewP();
            com.facebook.cache.common.b c = this.pyh.c(ewP, this.pBt.erD());
            if (ewP.exE() == ImageRequest.CacheChoice.SMALL) {
                this.pyg.a(c, eVar);
            } else {
                this.pzk.a(c, eVar);
            }
            exc().g(eVar, i);
        }
    }
}
