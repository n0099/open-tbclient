package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes18.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> oYc;
    private final int oYk;
    private final int oYl;
    private final boolean oYm;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.oYc = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.oYk = i;
        this.oYl = i2;
        this.oYm = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.eqY() && !this.oYm) {
            this.oYc.c(kVar, akVar);
        } else {
            this.oYc.c(new a(kVar, this.oYk, this.oYl), akVar);
        }
    }

    /* loaded from: classes18.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int oYk;
        private final int oYl;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.oYk = i;
            this.oYl = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            erh().h(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap epQ;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (epQ = ((com.facebook.imagepipeline.g.d) cVar).epQ()) != null && (rowBytes = epQ.getRowBytes() * epQ.getHeight()) >= this.oYk && rowBytes <= this.oYl) {
                epQ.prepareToDraw();
            }
        }
    }
}
