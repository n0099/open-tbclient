package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes8.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e nvb;
    private final com.facebook.imagepipeline.c.f nvc;
    private final com.facebook.imagepipeline.c.e nwh;
    private final aj<com.facebook.imagepipeline.g.e> nyd;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nwh = eVar;
        this.nvb = eVar2;
        this.nvc = fVar;
        this.nyd = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dVz().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.nyd.c(akVar.dVx().dSS() ? new a(kVar, akVar, this.nwh, this.nvb, this.nvc) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e nvb;
        private final com.facebook.imagepipeline.c.f nvc;
        private final com.facebook.imagepipeline.c.e nwh;
        private final ak nyq;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.nyq = akVar;
            this.nwh = eVar;
            this.nvb = eVar2;
            this.nvc = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Mm(i) || eVar == null || dK(i, 10) || eVar.dUA() == com.facebook.c.c.nsy) {
                dVJ().h(eVar, i);
                return;
            }
            ImageRequest dVx = this.nyq.dVx();
            com.facebook.cache.common.b c = this.nvc.c(dVx, this.nyq.dQd());
            if (dVx.dWo() == ImageRequest.CacheChoice.SMALL) {
                this.nvb.a(c, eVar);
            } else {
                this.nwh.a(c, eVar);
            }
            dVJ().h(eVar, i);
        }
    }
}
