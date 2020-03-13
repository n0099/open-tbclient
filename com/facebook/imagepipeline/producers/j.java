package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> lVx;
    private final aj<com.facebook.imagepipeline.g.e> lVy;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.lVx = ajVar;
        this.lVy = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lVx.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak lVz;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.lVz = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest dry = this.lVz.dry();
            boolean IJ = IJ(i);
            boolean a = ax.a(eVar, dry.dst());
            if (eVar != null && (a || dry.dsx())) {
                if (IJ && a) {
                    drK().g(eVar, i);
                } else {
                    drK().g(eVar, dz(i, 1));
                }
            }
            if (IJ && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.lVy.c(drK(), this.lVz);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            j.this.lVy.c(drK(), this.lVz);
        }
    }
}
