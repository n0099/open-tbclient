package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes9.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final int lQH;
    private final int lQI;
    private final boolean lQJ;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lQz;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.lQz = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lQH = i;
        this.lQI = i2;
        this.lQJ = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.dpa() && !this.lQJ) {
            this.lQz.c(kVar, akVar);
        } else {
            this.lQz.c(new a(kVar, this.lQH, this.lQI), akVar);
        }
    }

    /* loaded from: classes9.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int lQH;
        private final int lQI;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.lQH = i;
            this.lQI = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            dpj().g(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap dnV;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (dnV = ((com.facebook.imagepipeline.g.d) cVar).dnV()) != null && (rowBytes = dnV.getRowBytes() * dnV.getHeight()) >= this.lQH && rowBytes <= this.lQI) {
                dnV.prepareToDraw();
            }
        }
    }
}
