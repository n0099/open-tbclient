package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes8.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nxL;
    private final int nxT;
    private final int nxU;
    private final boolean nxV;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.nxL = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nxT = i;
        this.nxU = i2;
        this.nxV = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.dVr() && !this.nxV) {
            this.nxL.c(kVar, akVar);
        } else {
            this.nxL.c(new a(kVar, this.nxT, this.nxU), akVar);
        }
    }

    /* loaded from: classes8.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int nxT;
        private final int nxU;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.nxT = i;
            this.nxU = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            dVA().h(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap dUj;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (dUj = ((com.facebook.imagepipeline.g.d) cVar).dUj()) != null && (rowBytes = dUj.getRowBytes() * dUj.getHeight()) >= this.nxT && rowBytes <= this.nxU) {
                dUj.prepareToDraw();
            }
        }
    }
}
