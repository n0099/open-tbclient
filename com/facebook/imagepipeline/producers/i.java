package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
/* loaded from: classes4.dex */
public class i implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ndT;
    private final int neb;
    private final int nec;
    private final boolean ned;

    public i(aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar, int i, int i2, boolean z) {
        com.facebook.common.internal.g.checkArgument(i <= i2);
        this.ndT = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.neb = i;
        this.nec = i2;
        this.ned = z;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        if (akVar.dJr() && !this.ned) {
            this.ndT.c(kVar, akVar);
        } else {
            this.ndT.c(new a(kVar, this.neb, this.nec), akVar);
        }
    }

    /* loaded from: classes4.dex */
    private static class a extends n<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
        private final int neb;
        private final int nec;

        a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, int i, int i2) {
            super(kVar);
            this.neb = i;
            this.nec = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar, int i) {
            l(aVar);
            dJA().h(aVar, i);
        }

        private void l(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
            com.facebook.imagepipeline.g.c cVar;
            Bitmap dIj;
            int rowBytes;
            if (aVar != null && aVar.isValid() && (cVar = aVar.get()) != null && !cVar.isClosed() && (cVar instanceof com.facebook.imagepipeline.g.d) && (dIj = ((com.facebook.imagepipeline.g.d) cVar).dIj()) != null && (rowBytes = dIj.getRowBytes() * dIj.getHeight()) >= this.neb && rowBytes <= this.nec) {
                dIj.prepareToDraw();
            }
        }
    }
}
