package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes18.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final int nXA;
    private final boolean nXB;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nXr;
    private final int nXz;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.nXr = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nXz = i;
        this.nXA = i2;
        this.nXB = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.edj() && !this.nXB) {
            this.nXr.c(kVar, akVar);
        } else {
            this.nXr.c(new a(kVar, this.nXz, this.nXA), akVar);
        }
    }

    /* loaded from: classes18.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int nXA;
        private final int nXz;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.nXz = i;
            this.nXA = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            eds().h(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap ecb;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (ecb = ((com.facebook.imagepipeline.g.d) cVar).ecb()) != null && (rowBytes = ecb.getRowBytes() * ecb.getHeight()) >= this.nXz && rowBytes <= this.nXA) {
                ecb.prepareToDraw();
            }
        }
    }
}
