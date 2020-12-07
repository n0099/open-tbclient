package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes15.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final int poF;
    private final int poG;
    private final boolean poH;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pox;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.pox = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.poF = i;
        this.poG = i2;
        this.poH = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        if (akVar.ewy() && !this.poH) {
            this.pox.a(kVar, akVar);
        } else {
            this.pox.a(new a(kVar, this.poF, this.poG), akVar);
        }
    }

    /* loaded from: classes15.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final int poF;
        private final int poG;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, int i, int i2) {
            super(kVar);
            this.poF = i;
            this.poG = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            l(aVar);
            ewI().h(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
            com.facebook.imagepipeline.f.c cVar;
            Bitmap evt;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.f.d) && (evt = ((com.facebook.imagepipeline.f.d) cVar).evt()) != null && (rowBytes = evt.getRowBytes() * evt.getHeight()) >= this.poF && rowBytes <= this.poG) {
                evt.prepareToDraw();
            }
        }
    }
}
