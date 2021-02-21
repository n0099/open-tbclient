package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes5.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pLO;
    private final int pLW;
    private final int pLX;
    private final boolean pLY;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.pLO = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pLW = i;
        this.pLX = i2;
        this.pLY = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        if (akVar.ezs() && !this.pLY) {
            this.pLO.a(kVar, akVar);
        } else {
            this.pLO.a(new a(kVar, this.pLW, this.pLX), akVar);
        }
    }

    /* loaded from: classes5.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final int pLW;
        private final int pLX;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, int i, int i2) {
            super(kVar);
            this.pLW = i;
            this.pLX = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            l(aVar);
            ezC().g(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
            com.facebook.imagepipeline.f.c cVar;
            Bitmap eyo;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.f.d) && (eyo = ((com.facebook.imagepipeline.f.d) cVar).eyo()) != null && (rowBytes = eyo.getRowBytes() * eyo.getHeight()) >= this.pLW && rowBytes <= this.pLX) {
                eyo.prepareToDraw();
            }
        }
    }
}
