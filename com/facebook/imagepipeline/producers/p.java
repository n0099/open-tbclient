package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e mwI;
    private final com.facebook.imagepipeline.c.f mwJ;
    private final com.facebook.imagepipeline.c.e mxM;
    private final aj<com.facebook.imagepipeline.g.e> mzI;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mxM = eVar;
        this.mwI = eVar2;
        this.mwJ = fVar;
        this.mzI = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dBy().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.mzI.c(akVar.dBw().dyR() ? new a(kVar, akVar, this.mxM, this.mwI, this.mwJ) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e mwI;
        private final com.facebook.imagepipeline.c.f mwJ;
        private final com.facebook.imagepipeline.c.e mxM;
        private final ak mzV;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.mzV = akVar;
            this.mxM = eVar;
            this.mwI = eVar2;
            this.mwJ = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Ig(i) || eVar == null || dr(i, 10) || eVar.dAz() == com.facebook.c.c.muf) {
                dBI().h(eVar, i);
                return;
            }
            ImageRequest dBw = this.mzV.dBw();
            com.facebook.cache.common.b c = this.mwJ.c(dBw, this.mzV.dwa());
            if (dBw.dCn() == ImageRequest.CacheChoice.SMALL) {
                this.mwI.a(c, eVar);
            } else {
                this.mxM.a(c, eVar);
            }
            dBI().h(eVar, i);
        }
    }
}
