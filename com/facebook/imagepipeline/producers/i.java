package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes4.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ndV;
    private final int ned;
    private final int nee;
    private final boolean nef;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.ndV = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.ned = i;
        this.nee = i2;
        this.nef = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.dJs() && !this.nef) {
            this.ndV.c(kVar, akVar);
        } else {
            this.ndV.c(new a(kVar, this.ned, this.nee), akVar);
        }
    }

    /* loaded from: classes4.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int ned;
        private final int nee;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.ned = i;
            this.nee = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            dJB().h(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap dIk;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (dIk = ((com.facebook.imagepipeline.g.d) cVar).dIk()) != null && (rowBytes = dIk.getRowBytes() * dIk.getHeight()) >= this.ned && rowBytes <= this.nee) {
                dIk.prepareToDraw();
            }
        }
    }
}
