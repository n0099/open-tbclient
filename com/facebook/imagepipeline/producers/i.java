package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes3.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pBg;
    private final int pBo;
    private final int pBp;
    private final boolean pBq;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.pBg = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pBo = i;
        this.pBp = i2;
        this.pBq = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        if (akVar.ewS() && !this.pBq) {
            this.pBg.a(kVar, akVar);
        } else {
            this.pBg.a(new a(kVar, this.pBo, this.pBp), akVar);
        }
    }

    /* loaded from: classes3.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final int pBo;
        private final int pBp;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, int i, int i2) {
            super(kVar);
            this.pBo = i;
            this.pBp = i2;
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
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.f.d) && (evN = ((com.facebook.imagepipeline.f.d) cVar).evN()) != null && (rowBytes = evN.getRowBytes() * evN.getHeight()) >= this.pBo && rowBytes <= this.pBp) {
                evN.prepareToDraw();
            }
        }
    }
}
