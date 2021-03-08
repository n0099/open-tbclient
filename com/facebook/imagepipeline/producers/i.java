package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes5.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> pNT;
    private final int pOb;
    private final int pOc;
    private final boolean pOd;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.pNT = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pOb = i;
        this.pOc = i2;
        this.pOd = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        if (akVar.ezB() && !this.pOd) {
            this.pNT.a(kVar, akVar);
        } else {
            this.pNT.a(new a(kVar, this.pOb, this.pOc), akVar);
        }
    }

    /* loaded from: classes5.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
        private final int pOb;
        private final int pOc;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, int i, int i2) {
            super(kVar);
            this.pOb = i;
            this.pOc = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar, int i) {
            l(aVar);
            ezL().f(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
            com.facebook.imagepipeline.f.c cVar;
            Bitmap eyx;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.f.d) && (eyx = ((com.facebook.imagepipeline.f.d) cVar).eyx()) != null && (rowBytes = eyx.getRowBytes() * eyx.getHeight()) >= this.pOb && rowBytes <= this.pOc) {
                eyx.prepareToDraw();
            }
        }
    }
}
