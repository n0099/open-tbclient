package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> lVm;
    private final aj<com.facebook.imagepipeline.g.e> lVn;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.lVm = ajVar;
        this.lVn = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lVm.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak lVo;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.lVo = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest drx = this.lVo.drx();
            boolean IJ = IJ(i);
            boolean a = ax.a(eVar, drx.dss());
            if (eVar != null && (a || drx.dsw())) {
                if (IJ && a) {
                    drJ().g(eVar, i);
                } else {
                    drJ().g(eVar, dz(i, 1));
                }
            }
            if (IJ && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.lVn.c(drJ(), this.lVo);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            j.this.lVn.c(drJ(), this.lVo);
        }
    }
}
