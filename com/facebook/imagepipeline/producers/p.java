package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class p implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.e pIO;
    private final com.facebook.imagepipeline.b.f pIP;
    private final com.facebook.imagepipeline.b.e pJS;
    private final aj<com.facebook.imagepipeline.f.e> pLO;

    public p(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pJS = eVar;
        this.pIO = eVar2;
        this.pIP = fVar;
        this.pLO = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        c(kVar, akVar);
    }

    private void c(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.ezr().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.pLO.a(akVar.ezp().ewO() ? new a(kVar, akVar, this.pJS, this.pIO, this.pIP) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.b.e pIO;
        private final com.facebook.imagepipeline.b.f pIP;
        private final com.facebook.imagepipeline.b.e pJS;
        private final ak pMb;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar) {
            super(kVar);
            this.pMb = akVar;
            this.pJS = eVar;
            this.pIO = eVar2;
            this.pIP = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (Ql(i) || eVar == null || ee(i, 10) || eVar.eyw() == com.facebook.c.c.pGy) {
                ezC().g(eVar, i);
                return;
            }
            ImageRequest ezp = this.pMb.ezp();
            com.facebook.cache.common.b c = this.pIP.c(ezp, this.pMb.eud());
            if (ezp.eAe() == ImageRequest.CacheChoice.SMALL) {
                this.pIO.a(c, eVar);
            } else {
                this.pJS.a(c, eVar);
            }
            ezC().g(eVar, i);
        }
    }
}
