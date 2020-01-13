package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes10.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> lUy;
    private final aj<com.facebook.imagepipeline.g.e> lUz;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.lUy = ajVar;
        this.lUz = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lUy.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes10.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak lUA;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.lUA = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest dqh = this.lUA.dqh();
            boolean IE = IE(i);
            boolean a = ax.a(eVar, dqh.drc());
            if (eVar != null && (a || dqh.drg())) {
                if (IE && a) {
                    dqt().g(eVar, i);
                } else {
                    dqt().g(eVar, dw(i, 1));
                }
            }
            if (IE && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.lUz.c(dqt(), this.lUA);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            j.this.lUz.c(dqt(), this.lUA);
        }
    }
}
