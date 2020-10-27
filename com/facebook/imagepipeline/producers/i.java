package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes18.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oOJ;
    private final int oOR;
    private final int oOS;
    private final boolean oOT;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.oOJ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.oOR = i;
        this.oOS = i2;
        this.oOT = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.eni() && !this.oOT) {
            this.oOJ.c(kVar, akVar);
        } else {
            this.oOJ.c(new a(kVar, this.oOR, this.oOS), akVar);
        }
    }

    /* loaded from: classes18.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int oOR;
        private final int oOS;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.oOR = i;
            this.oOS = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            enr().h(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap elZ;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (elZ = ((com.facebook.imagepipeline.g.d) cVar).elZ()) != null && (rowBytes = elZ.getRowBytes() * elZ.getHeight()) >= this.oOR && rowBytes <= this.oOS) {
                elZ.prepareToDraw();
            }
        }
    }
}
