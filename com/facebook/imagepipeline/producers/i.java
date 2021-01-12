package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes3.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pBf;
    private final int pBn;
    private final int pBo;
    private final boolean pBp;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.pBf = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pBn = i;
        this.pBo = i2;
        this.pBp = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        if (akVar.ewS() && !this.pBp) {
            this.pBf.a(kVar, akVar);
        } else {
            this.pBf.a(new a(kVar, this.pBn, this.pBo), akVar);
        }
    }

    /* loaded from: classes3.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final int pBn;
        private final int pBo;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, int i, int i2) {
            super(kVar);
            this.pBn = i;
            this.pBo = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            l(aVar);
            exc().g(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
            com.facebook.imagepipeline.f.c cVar;
            Bitmap evN;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.f.d) && (evN = ((com.facebook.imagepipeline.f.d) cVar).evN()) != null && (rowBytes = evN.getRowBytes() * evN.getHeight()) >= this.pBn && rowBytes <= this.pBo) {
                evN.prepareToDraw();
            }
        }
    }
}
