package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> oZQ;
    private final aj<com.facebook.imagepipeline.g.e> oZR;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.oZQ = ajVar;
        this.oZR = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.oZQ.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes15.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak oZS;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.oZS = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest eqT = this.oZS.eqT();
            boolean Ql = Ql(i);
            boolean a2 = ax.a(eVar, eqT.erN());
            if (eVar != null && (a2 || eqT.erR())) {
                if (Ql && a2) {
                    erf().h(eVar, i);
                } else {
                    erf().h(eVar, dZ(i, 1));
                }
            }
            if (Ql && !a2) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.oZR.c(erf(), this.oZS);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            j.this.oZR.c(erf(), this.oZS);
        }
    }
}
