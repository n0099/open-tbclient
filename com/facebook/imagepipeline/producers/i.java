package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes10.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final int lUA;
    private final int lUB;
    private final boolean lUC;
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> lUs;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.lUs = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lUA = i;
        this.lUB = i2;
        this.lUC = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.dqm() && !this.lUC) {
            this.lUs.c(kVar, akVar);
        } else {
            this.lUs.c(new a(kVar, this.lUA, this.lUB), akVar);
        }
    }

    /* loaded from: classes10.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int lUA;
        private final int lUB;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.lUA = i;
            this.lUB = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            dqv().g(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap dpd;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (dpd = ((com.facebook.imagepipeline.g.d) cVar).dpd()) != null && (rowBytes = dpd.getRowBytes() * dpd.getHeight()) >= this.lUA && rowBytes <= this.lUB) {
                dpd.prepareToDraw();
            }
        }
    }
}
