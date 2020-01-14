package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes10.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> lUD;
    private final aj<com.facebook.imagepipeline.g.e> lUE;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.lUD = ajVar;
        this.lUE = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lUD.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes10.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak lUF;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.lUF = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest dqj = this.lUF.dqj();
            boolean IE = IE(i);
            boolean a = ax.a(eVar, dqj.dre());
            if (eVar != null && (a || dqj.dri())) {
                if (IE && a) {
                    dqv().g(eVar, i);
                } else {
                    dqv().g(eVar, dw(i, 1));
                }
            }
            if (IE && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.lUE.c(dqv(), this.lUF);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            j.this.lUE.c(dqv(), this.lUF);
        }
    }
}
