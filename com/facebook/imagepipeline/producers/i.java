package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes10.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lUn;
    private final int lUv;
    private final int lUw;
    private final boolean lUx;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.lUn = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lUv = i;
        this.lUw = i2;
        this.lUx = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.dqk() && !this.lUx) {
            this.lUn.c(kVar, akVar);
        } else {
            this.lUn.c(new a(kVar, this.lUv, this.lUw), akVar);
        }
    }

    /* loaded from: classes10.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int lUv;
        private final int lUw;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.lUv = i;
            this.lUw = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            dqt().g(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap dpb;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (dpb = ((com.facebook.imagepipeline.g.d) cVar).dpb()) != null && (rowBytes = dpb.getRowBytes() * dpb.getHeight()) >= this.lUv && rowBytes <= this.lUw) {
                dpb.prepareToDraw();
            }
        }
    }
}
