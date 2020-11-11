package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> oYn;
    private final aj<com.facebook.imagepipeline.g.e> oYo;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.oYn = ajVar;
        this.oYo = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.oYn.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes18.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak oYp;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.oYp = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest eqV = this.oYp.eqV();
            boolean PI = PI(i);
            boolean a2 = ax.a(eVar, eqV.erP());
            if (eVar != null && (a2 || eqV.erT())) {
                if (PI && a2) {
                    erh().h(eVar, i);
                } else {
                    erh().h(eVar, dY(i, 1));
                }
            }
            if (PI && !a2) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.oYo.c(erh(), this.oYp);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            j.this.oYo.c(erh(), this.oYp);
        }
    }
}
