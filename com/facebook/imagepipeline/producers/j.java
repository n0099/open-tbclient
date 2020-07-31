package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> nee;
    private final aj<com.facebook.imagepipeline.g.e> nef;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.nee = ajVar;
        this.nef = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.nee.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes4.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak neg;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.neg = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest dJo = this.neg.dJo();
            boolean JH = JH(i);
            boolean a = ax.a(eVar, dJo.dKi());
            if (eVar != null && (a || dJo.dKm())) {
                if (JH && a) {
                    dJA().h(eVar, i);
                } else {
                    dJA().h(eVar, dA(i, 1));
                }
            }
            if (JH && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.nef.c(dJA(), this.neg);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void E(Throwable th) {
            j.this.nef.c(dJA(), this.neg);
        }
    }
}
