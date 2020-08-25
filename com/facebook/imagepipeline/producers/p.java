package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes8.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e nuJ;
    private final com.facebook.imagepipeline.c.f nuK;
    private final com.facebook.imagepipeline.c.e nvP;
    private final aj<com.facebook.imagepipeline.g.e> nxL;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nvP = eVar;
        this.nuJ = eVar2;
        this.nuK = fVar;
        this.nxL = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dVq().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.nxL.c(akVar.dVo().dSJ() ? new a(kVar, akVar, this.nvP, this.nuJ, this.nuK) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e nuJ;
        private final com.facebook.imagepipeline.c.f nuK;
        private final com.facebook.imagepipeline.c.e nvP;
        private final ak nxY;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.nxY = akVar;
            this.nvP = eVar;
            this.nuJ = eVar2;
            this.nuK = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Mm(i) || eVar == null || dK(i, 10) || eVar.dUr() == com.facebook.c.c.nsg) {
                dVA().h(eVar, i);
                return;
            }
            ImageRequest dVo = this.nxY.dVo();
            com.facebook.cache.common.b c = this.nuK.c(dVo, this.nxY.dPU());
            if (dVo.dWf() == ImageRequest.CacheChoice.SMALL) {
                this.nuJ.a(c, eVar);
            } else {
                this.nvP.a(c, eVar);
            }
            dVA().h(eVar, i);
        }
    }
}
