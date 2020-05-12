package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes12.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> meH;
    private final int meP;
    private final int meQ;
    private final boolean meR;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.meH = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.meP = i;
        this.meQ = i2;
        this.meR = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.dtU() && !this.meR) {
            this.meH.c(kVar, akVar);
        } else {
            this.meH.c(new a(kVar, this.meP, this.meQ), akVar);
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int meP;
        private final int meQ;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.meP = i;
            this.meQ = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            dud().h(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap dsL;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (dsL = ((com.facebook.imagepipeline.g.d) cVar).dsL()) != null && (rowBytes = dsL.getRowBytes() * dsL.getHeight()) >= this.meP && rowBytes <= this.meQ) {
                dsL.prepareToDraw();
            }
        }
    }
}
