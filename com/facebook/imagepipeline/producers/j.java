package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> neg;
    private final aj<com.facebook.imagepipeline.g.e> neh;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.neg = ajVar;
        this.neh = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.neg.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes4.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak nei;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.nei = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest dJp = this.nei.dJp();
            boolean JH = JH(i);
            boolean a = ax.a(eVar, dJp.dKj());
            if (eVar != null && (a || dJp.dKn())) {
                if (JH && a) {
                    dJB().h(eVar, i);
                } else {
                    dJB().h(eVar, dA(i, 1));
                }
            }
            if (JH && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.neh.c(dJB(), this.nei);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void E(Throwable th) {
            j.this.neh.c(dJB(), this.nei);
        }
    }
}
