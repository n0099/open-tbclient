package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class p implements aj<com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.e nUr;
    private final com.facebook.imagepipeline.c.f nUs;
    private final com.facebook.imagepipeline.c.e nVv;
    private final aj<com.facebook.imagepipeline.g.e> nXr;

    public p(com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.nVv = eVar;
        this.nUr = eVar2;
        this.nUs = fVar;
        this.nXr = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        e(kVar, akVar);
    }

    private void e(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.edi().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            kVar.h(null, 1);
        } else {
            this.nXr.c(akVar.edg().eaB() ? new a(kVar, akVar, this.nVv, this.nUr, this.nUs) : kVar, akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.c.e nUr;
        private final com.facebook.imagepipeline.c.f nUs;
        private final com.facebook.imagepipeline.c.e nVv;
        private final ak nXE;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, com.facebook.imagepipeline.c.e eVar, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.f fVar) {
            super(kVar);
            this.nXE = akVar;
            this.nVv = eVar;
            this.nUr = eVar2;
            this.nUs = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (Nx(i) || eVar == null || dO(i, 10) || eVar.ecj() == com.facebook.c.c.nRP) {
                eds().h(eVar, i);
                return;
            }
            ImageRequest edg = this.nXE.edg();
            com.facebook.cache.common.b c = this.nUs.c(edg, this.nXE.dXM());
            if (edg.edX() == ImageRequest.CacheChoice.SMALL) {
                this.nUr.a(c, eVar);
            } else {
                this.nVv.a(c, eVar);
            }
            eds().h(eVar, i);
        }
    }
}
