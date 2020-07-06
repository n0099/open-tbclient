package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes12.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> mVS;
    private final int mWa;
    private final int mWb;
    private final boolean mWc;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.mVS = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mWa = i;
        this.mWb = i2;
        this.mWc = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.dGf() && !this.mWc) {
            this.mVS.c(kVar, akVar);
        } else {
            this.mVS.c(new a(kVar, this.mWa, this.mWb), akVar);
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int mWa;
        private final int mWb;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.mWa = i;
            this.mWb = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            dGo().h(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap dEX;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (dEX = ((com.facebook.imagepipeline.g.d) cVar).dEX()) != null && (rowBytes = dEX.getRowBytes() * dEX.getHeight()) >= this.mWa && rowBytes <= this.mWb) {
                dEX.prepareToDraw();
            }
        }
    }
}
