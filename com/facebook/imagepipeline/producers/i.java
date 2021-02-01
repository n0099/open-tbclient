package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes5.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pLo;
    private final int pLw;
    private final int pLx;
    private final boolean pLy;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.pLo = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pLw = i;
        this.pLx = i2;
        this.pLy = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        if (akVar.ezk() && !this.pLy) {
            this.pLo.a(kVar, akVar);
        } else {
            this.pLo.a(new a(kVar, this.pLw, this.pLx), akVar);
        }
    }

    /* loaded from: classes5.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final int pLw;
        private final int pLx;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, int i, int i2) {
            super(kVar);
            this.pLw = i;
            this.pLx = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            l(aVar);
            ezu().g(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
            com.facebook.imagepipeline.f.c cVar;
            Bitmap eyg;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.f.d) && (eyg = ((com.facebook.imagepipeline.f.d) cVar).eyg()) != null && (rowBytes = eyg.getRowBytes() * eyg.getHeight()) >= this.pLw && rowBytes <= this.pLx) {
                eyg.prepareToDraw();
            }
        }
    }
}
