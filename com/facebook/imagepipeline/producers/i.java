package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes5.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pDZ;
    private final int pEh;
    private final int pEi;
    private final boolean pEj;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.pDZ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pEh = i;
        this.pEi = i2;
        this.pEj = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        if (akVar.eAg() && !this.pEj) {
            this.pDZ.a(kVar, akVar);
        } else {
            this.pDZ.a(new a(kVar, this.pEh, this.pEi), akVar);
        }
    }

    /* loaded from: classes5.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final int pEh;
        private final int pEi;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, int i, int i2) {
            super(kVar);
            this.pEh = i;
            this.pEi = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            i(aVar);
            eAq().g(aVar, i);
        }

        private void i(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
            com.facebook.imagepipeline.f.c cVar;
            Bitmap ezc;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.f.d) && (ezc = ((com.facebook.imagepipeline.f.d) cVar).ezc()) != null && (rowBytes = ezc.getRowBytes() * ezc.getHeight()) >= this.pEh && rowBytes <= this.pEi) {
                ezc.prepareToDraw();
            }
        }
    }
}
