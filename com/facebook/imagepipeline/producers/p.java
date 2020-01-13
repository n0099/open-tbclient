package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes10.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e lRl;
    private final com.facebook.imagepipeline.c.f lRm;
    private final com.facebook.imagepipeline.c.e lSr;
    private final aj<com.facebook.imagepipeline.g.e> lUn;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lSr = eVar;
        this.lRl = eVar2;
        this.lRm = fVar;
        this.lUn = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dqj().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.lUn.c(akVar.dqh().dnB() ? new a(kVar, akVar, this.lSr, this.lRl, this.lRm) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e lRl;
        private final com.facebook.imagepipeline.c.f lRm;
        private final com.facebook.imagepipeline.c.e lSr;
        private final ak lUA;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.lUA = akVar;
            this.lSr = eVar;
            this.lRl = eVar2;
            this.lRm = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (IF(i) || eVar == null || dy(i, 10) || eVar.dpj() == com.facebook.c.c.lOM) {
                dqt().g(eVar, i);
                return;
            }
            ImageRequest dqh = this.lUA.dqh();
            com.facebook.cache.common.b c = this.lRm.c(dqh, this.lUA.dkO());
            if (dqh.dqZ() == ImageRequest.CacheChoice.SMALL) {
                this.lRl.a(c, eVar);
            } else {
                this.lSr.a(c, eVar);
            }
            dqt().g(eVar, i);
        }
    }
}
