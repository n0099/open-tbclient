package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes12.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lVm;
    private final int lVu;
    private final int lVv;
    private final boolean lVw;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.lVm = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lVu = i;
        this.lVv = i2;
        this.lVw = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.drB() && !this.lVw) {
            this.lVm.c(kVar, akVar);
        } else {
            this.lVm.c(new a(kVar, this.lVu, this.lVv), akVar);
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int lVu;
        private final int lVv;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.lVu = i;
            this.lVv = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            drK().g(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap dqs;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (dqs = ((com.facebook.imagepipeline.g.d) cVar).dqs()) != null && (rowBytes = dqs.getRowBytes() * dqs.getHeight()) >= this.lVu && rowBytes <= this.lVv) {
                dqs.prepareToDraw();
            }
        }
    }
}
