package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class p implements aj<com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.e plu;
    private final com.facebook.imagepipeline.b.f plv;
    private final com.facebook.imagepipeline.b.e pmy;
    private final aj<com.facebook.imagepipeline.f.e> pox;

    public p(com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pmy = eVar;
        this.plu = eVar2;
        this.plv = fVar;
        this.pox = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        c(kVar, akVar);
    }

    private void c(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.ewx().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.pox.a(akVar.ewv().etT() ? new a(kVar, akVar, this.pmy, this.plu, this.plv) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.b.e plu;
        private final com.facebook.imagepipeline.b.f plv;
        private final com.facebook.imagepipeline.b.e pmy;
        private final ak poK;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, com.facebook.imagepipeline.b.e eVar, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.f fVar) {
            super(kVar);
            this.poK = akVar;
            this.pmy = eVar;
            this.plu = eVar2;
            this.plv = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.f.e eVar, int i) {
            if (Ri(i) || eVar == null || eg(i, 10) || eVar.evB() == com.facebook.c.c.pjc) {
                ewI().h(eVar, i);
                return;
            }
            ImageRequest ewv = this.poK.ewv();
            com.facebook.cache.common.b c = this.plv.c(ewv, this.poK.erm());
            if (ewv.exk() == ImageRequest.CacheChoice.SMALL) {
                this.plu.a(c, eVar);
            } else {
                this.pmy.a(c, eVar);
            }
            ewI().h(eVar, i);
        }
    }
}
