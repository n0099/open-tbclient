package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class p implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.e pKT;
    private final com.facebook.imagepipeline.b.f pKU;
    private final com.facebook.imagepipeline.b.e pLX;
    private final aj<com.facebook.imagepipeline.f.e> pNT;

    public p(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pLX = eVar;
        this.pKT = eVar2;
        this.pKU = fVar;
        this.pNT = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        c(kVar, akVar);
    }

    private void c(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.ezA().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.f(null, 1);
        } else {
            this.pNT.a(akVar.ezy().ewX() ? new a(kVar, akVar, this.pLX, this.pKT, this.pKU) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.b.e pKT;
        private final com.facebook.imagepipeline.b.f pKU;
        private final com.facebook.imagepipeline.b.e pLX;
        private final ak pOg;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar) {
            super(kVar);
            this.pOg = akVar;
            this.pLX = eVar;
            this.pKT = eVar2;
            this.pKU = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.imagepipeline.f.e eVar, int i) {
            if (Qp(i) || eVar == null || ee(i, 10) || eVar.eyF() == com.facebook.c.c.pID) {
                ezL().f(eVar, i);
                return;
            }
            ImageRequest ezy = this.pOg.ezy();
            com.facebook.cache.common.b c = this.pKU.c(ezy, this.pOg.eum());
            if (ezy.eAn() == ImageRequest.CacheChoice.SMALL) {
                this.pKT.a(c, eVar);
            } else {
                this.pLX.a(c, eVar);
            }
            ezL().f(eVar, i);
        }
    }
}
