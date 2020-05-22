package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes12.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final int myG;
    private final int myH;
    private final boolean myI;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> myy;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.myy = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.myG = i;
        this.myH = i2;
        this.myI = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.dBl() && !this.myI) {
            this.myy.c(kVar, akVar);
        } else {
            this.myy.c(new a(kVar, this.myG, this.myH), akVar);
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int myG;
        private final int myH;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.myG = i;
            this.myH = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            dBu().h(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap dAd;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (dAd = ((com.facebook.imagepipeline.g.d) cVar).dAd()) != null && (rowBytes = dAd.getRowBytes() * dAd.getHeight()) >= this.myG && rowBytes <= this.myH) {
                dAd.prepareToDraw();
            }
        }
    }
}
