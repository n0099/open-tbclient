package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class p implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.e plw;
    private final com.facebook.imagepipeline.b.f plx;
    private final com.facebook.imagepipeline.b.e pmA;
    private final aj<com.facebook.imagepipeline.f.e> poz;

    public p(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pmA = eVar;
        this.plw = eVar2;
        this.plx = fVar;
        this.poz = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        c(kVar, akVar);
    }

    private void c(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.ewy().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.poz.a(akVar.eww().etU() ? new a(kVar, akVar, this.pmA, this.plw, this.plx) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.b.e plw;
        private final com.facebook.imagepipeline.b.f plx;
        private final com.facebook.imagepipeline.b.e pmA;
        private final ak poM;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar) {
            super(kVar);
            this.poM = akVar;
            this.pmA = eVar;
            this.plw = eVar2;
            this.plx = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.f.e eVar, int i) {
            if (Ri(i) || eVar == null || eg(i, 10) || eVar.evC() == com.facebook.c.c.pje) {
                ewJ().h(eVar, i);
                return;
            }
            ImageRequest eww = this.poM.eww();
            com.facebook.cache.common.b c = this.plx.c(eww, this.poM.ern());
            if (eww.exl() == ImageRequest.CacheChoice.SMALL) {
                this.plw.a(c, eVar);
            } else {
                this.pmA.a(c, eVar);
            }
            ewJ().h(eVar, i);
        }
    }
}
