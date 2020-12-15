package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes15.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final int poH;
    private final int poI;
    private final boolean poJ;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> poz;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.poz = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.poH = i;
        this.poI = i2;
        this.poJ = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        if (akVar.ewz() && !this.poJ) {
            this.poz.a(kVar, akVar);
        } else {
            this.poz.a(new a(kVar, this.poH, this.poI), akVar);
        }
    }

    /* loaded from: classes15.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final int poH;
        private final int poI;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, int i, int i2) {
            super(kVar);
            this.poH = i;
            this.poI = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            l(aVar);
            ewJ().h(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
            com.facebook.imagepipeline.f.c cVar;
            Bitmap evu;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.f.d) && (evu = ((com.facebook.imagepipeline.f.d) cVar).evu()) != null && (rowBytes = evu.getRowBytes() * evu.getHeight()) >= this.poH && rowBytes <= this.poI) {
                evu.prepareToDraw();
            }
        }
    }
}
