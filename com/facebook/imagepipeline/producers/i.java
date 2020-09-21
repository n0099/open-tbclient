package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes25.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nIa;
    private final int nIi;
    private final int nIj;
    private final boolean nIk;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.nIa = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nIi = i;
        this.nIj = i2;
        this.nIk = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.dZy() && !this.nIk) {
            this.nIa.c(kVar, akVar);
        } else {
            this.nIa.c(new a(kVar, this.nIi, this.nIj), akVar);
        }
    }

    /* loaded from: classes25.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int nIi;
        private final int nIj;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.nIi = i;
            this.nIj = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            dZH().h(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap dYq;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (dYq = ((com.facebook.imagepipeline.g.d) cVar).dYq()) != null && (rowBytes = dYq.getRowBytes() * dYq.getHeight()) >= this.nIi && rowBytes <= this.nIj) {
                dYq.prepareToDraw();
            }
        }
    }
}
