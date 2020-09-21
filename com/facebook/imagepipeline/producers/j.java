package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes25.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> nIl;
    private final aj<com.facebook.imagepipeline.g.e> nIm;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.nIl = ajVar;
        this.nIm = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.nIl.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes25.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak nIn;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.nIn = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest dZv = this.nIn.dZv();
            boolean MQ = MQ(i);
            boolean a = ax.a(eVar, dZv.eap());
            if (eVar != null && (a || dZv.eat())) {
                if (MQ && a) {
                    dZH().h(eVar, i);
                } else {
                    dZH().h(eVar, dM(i, 1));
                }
            }
            if (MQ && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.nIm.c(dZH(), this.nIn);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            j.this.nIm.c(dZH(), this.nIn);
        }
    }
}
