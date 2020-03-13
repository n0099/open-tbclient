package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e lSk;
    private final com.facebook.imagepipeline.c.f lSl;
    private final com.facebook.imagepipeline.c.e lTq;
    private final aj<com.facebook.imagepipeline.g.e> lVm;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lTq = eVar;
        this.lSk = eVar2;
        this.lSl = fVar;
        this.lVm = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.drA().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.lVm.c(akVar.dry().doS() ? new a(kVar, akVar, this.lTq, this.lSk, this.lSl) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e lSk;
        private final com.facebook.imagepipeline.c.f lSl;
        private final com.facebook.imagepipeline.c.e lTq;
        private final ak lVz;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.lVz = akVar;
            this.lTq = eVar;
            this.lSk = eVar2;
            this.lSl = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (IK(i) || eVar == null || dB(i, 10) || eVar.dqA() == com.facebook.c.c.lPL) {
                drK().g(eVar, i);
                return;
            }
            ImageRequest dry = this.lVz.dry();
            com.facebook.cache.common.b c = this.lSl.c(dry, this.lVz.dmg());
            if (dry.dsq() == ImageRequest.CacheChoice.SMALL) {
                this.lSk.a(c, eVar);
            } else {
                this.lTq.a(c, eVar);
            }
            drK().g(eVar, i);
        }
    }
}
