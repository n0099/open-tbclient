package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> lVk;
    private final aj<com.facebook.imagepipeline.g.e> lVl;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.lVk = ajVar;
        this.lVl = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lVk.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak lVm;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.lVm = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest drv = this.lVm.drv();
            boolean IJ = IJ(i);
            boolean a = ax.a(eVar, drv.dsq());
            if (eVar != null && (a || drv.dsu())) {
                if (IJ && a) {
                    drH().g(eVar, i);
                } else {
                    drH().g(eVar, dz(i, 1));
                }
            }
            if (IJ && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.lVl.c(drH(), this.lVm);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            j.this.lVl.c(drH(), this.lVm);
        }
    }
}
