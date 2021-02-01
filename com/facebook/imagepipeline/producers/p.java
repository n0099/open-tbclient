package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class p implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.e pIo;
    private final com.facebook.imagepipeline.b.f pIp;
    private final com.facebook.imagepipeline.b.e pJs;
    private final aj<com.facebook.imagepipeline.f.e> pLo;

    public p(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pJs = eVar;
        this.pIo = eVar2;
        this.pIp = fVar;
        this.pLo = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        c(kVar, akVar);
    }

    private void c(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.ezj().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.pLo.a(akVar.ezh().ewG() ? new a(kVar, akVar, this.pJs, this.pIo, this.pIp) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.b.e pIo;
        private final com.facebook.imagepipeline.b.f pIp;
        private final com.facebook.imagepipeline.b.e pJs;
        private final ak pLB;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar) {
            super(kVar);
            this.pLB = akVar;
            this.pJs = eVar;
            this.pIo = eVar2;
            this.pIp = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (Qk(i) || eVar == null || ed(i, 10) || eVar.eyo() == com.facebook.c.c.pFY) {
                ezu().g(eVar, i);
                return;
            }
            ImageRequest ezh = this.pLB.ezh();
            com.facebook.cache.common.b c = this.pIp.c(ezh, this.pLB.etV());
            if (ezh.ezW() == ImageRequest.CacheChoice.SMALL) {
                this.pIo.a(c, eVar);
            } else {
                this.pJs.a(c, eVar);
            }
            ezu().g(eVar, i);
        }
    }
}
