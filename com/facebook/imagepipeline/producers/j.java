package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes8.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> nxW;
    private final aj<com.facebook.imagepipeline.g.e> nxX;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.nxW = ajVar;
        this.nxX = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.nxW.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes8.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak nxY;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.nxY = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest dVo = this.nxY.dVo();
            boolean Ml = Ml(i);
            boolean a = ax.a(eVar, dVo.dWi());
            if (eVar != null && (a || dVo.dWm())) {
                if (Ml && a) {
                    dVA().h(eVar, i);
                } else {
                    dVA().h(eVar, dI(i, 1));
                }
            }
            if (Ml && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.nxX.c(dVA(), this.nxY);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            j.this.nxX.c(dVA(), this.nxY);
        }
    }
}
