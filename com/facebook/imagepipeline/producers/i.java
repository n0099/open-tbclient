package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes12.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lWS;
    private final int lXa;
    private final int lXb;
    private final boolean lXc;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.lWS = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lXa = i;
        this.lXb = i2;
        this.lXc = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.drY() && !this.lXc) {
            this.lWS.c(kVar, akVar);
        } else {
            this.lWS.c(new a(kVar, this.lXa, this.lXb), akVar);
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int lXa;
        private final int lXb;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.lXa = i;
            this.lXb = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            dsh().g(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap dqP;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (dqP = ((com.facebook.imagepipeline.g.d) cVar).dqP()) != null && (rowBytes = dqP.getRowBytes() * dqP.getHeight()) >= this.lXa && rowBytes <= this.lXb) {
                dqP.prepareToDraw();
            }
        }
    }
}
