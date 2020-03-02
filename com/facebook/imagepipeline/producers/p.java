package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e lRZ;
    private final com.facebook.imagepipeline.c.f lSa;
    private final com.facebook.imagepipeline.c.e lTf;
    private final aj<com.facebook.imagepipeline.g.e> lVb;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lTf = eVar;
        this.lRZ = eVar2;
        this.lSa = fVar;
        this.lVb = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.drz().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.g(null, 1);
        } else {
            this.lVb.c(akVar.drx().doR() ? new a(kVar, akVar, this.lTf, this.lRZ, this.lSa) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e lRZ;
        private final com.facebook.imagepipeline.c.f lSa;
        private final com.facebook.imagepipeline.c.e lTf;
        private final ak lVo;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.lVo = akVar;
            this.lTf = eVar;
            this.lRZ = eVar2;
            this.lSa = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (IK(i) || eVar == null || dB(i, 10) || eVar.dqz() == com.facebook.c.c.lPA) {
                drJ().g(eVar, i);
                return;
            }
            ImageRequest drx = this.lVo.drx();
            com.facebook.cache.common.b c = this.lSa.c(drx, this.lVo.dmf());
            if (drx.dsp() == ImageRequest.CacheChoice.SMALL) {
                this.lRZ.a(c, eVar);
            } else {
                this.lTf.a(c, eVar);
            }
            drJ().g(eVar, i);
        }
    }
}
