package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes8.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> nyd;
    private final int nyl;
    private final int nym;
    private final boolean nyn;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.nyd = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nyl = i;
        this.nym = i2;
        this.nyn = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.dVA() && !this.nyn) {
            this.nyd.c(kVar, akVar);
        } else {
            this.nyd.c(new a(kVar, this.nyl, this.nym), akVar);
        }
    }

    /* loaded from: classes8.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int nyl;
        private final int nym;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.nyl = i;
            this.nym = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            dVJ().h(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap dUs;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (dUs = ((com.facebook.imagepipeline.g.d) cVar).dUs()) != null && (rowBytes = dUs.getRowBytes() * dUs.getHeight()) >= this.nyl && rowBytes <= this.nym) {
                dUs.prepareToDraw();
            }
        }
    }
}
