package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes15.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oZF;
    private final int oZN;
    private final int oZO;
    private final boolean oZP;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.oZF = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.oZN = i;
        this.oZO = i2;
        this.oZP = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.eqW() && !this.oZP) {
            this.oZF.c(kVar, akVar);
        } else {
            this.oZF.c(new a(kVar, this.oZN, this.oZO), akVar);
        }
    }

    /* loaded from: classes15.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int oZN;
        private final int oZO;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.oZN = i;
            this.oZO = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            erf().h(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap epO;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (epO = ((com.facebook.imagepipeline.g.d) cVar).epO()) != null && (rowBytes = epO.getRowBytes() * epO.getHeight()) >= this.oZN && rowBytes <= this.oZO) {
                epO.prepareToDraw();
            }
        }
    }
}
