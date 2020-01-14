package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes10.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e lRq;
    private final com.facebook.imagepipeline.c.f lRr;
    private final com.facebook.imagepipeline.c.e lSw;
    private final aj<com.facebook.imagepipeline.g.e> lUs;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lSw = eVar;
        this.lRq = eVar2;
        this.lRr = fVar;
        this.lUs = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dql().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.lUs.c(akVar.dqj().dnD() ? new a(kVar, akVar, this.lSw, this.lRq, this.lRr) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e lRq;
        private final com.facebook.imagepipeline.c.f lRr;
        private final com.facebook.imagepipeline.c.e lSw;
        private final ak lUF;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.lUF = akVar;
            this.lSw = eVar;
            this.lRq = eVar2;
            this.lRr = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (IF(i) || eVar == null || dy(i, 10) || eVar.dpl() == com.facebook.c.c.lOR) {
                dqv().g(eVar, i);
                return;
            }
            ImageRequest dqj = this.lUF.dqj();
            com.facebook.cache.common.b c = this.lRr.c(dqj, this.lUF.dkQ());
            if (dqj.drb() == ImageRequest.CacheChoice.SMALL) {
                this.lRq.a(c, eVar);
            } else {
                this.lSw.a(c, eVar);
            }
            dqv().g(eVar, i);
        }
    }
}
