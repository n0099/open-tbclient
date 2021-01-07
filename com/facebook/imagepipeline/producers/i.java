package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes3.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pFG;
    private final int pFO;
    private final int pFP;
    private final boolean pFQ;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.pFG = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pFO = i;
        this.pFP = i2;
        this.pFQ = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        if (akVar.eAK() && !this.pFQ) {
            this.pFG.a(kVar, akVar);
        } else {
            this.pFG.a(new a(kVar, this.pFO, this.pFP), akVar);
        }
    }

    /* loaded from: classes3.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final int pFO;
        private final int pFP;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, int i, int i2) {
            super(kVar);
            this.pFO = i;
            this.pFP = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            l(aVar);
            eAU().g(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
            com.facebook.imagepipeline.f.c cVar;
            Bitmap ezF;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.f.d) && (ezF = ((com.facebook.imagepipeline.f.d) cVar).ezF()) != null && (rowBytes = ezF.getRowBytes() * ezF.getHeight()) >= this.pFO && rowBytes <= this.pFP) {
                ezF.prepareToDraw();
            }
        }
    }
}
