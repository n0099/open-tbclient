package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes9.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> lQK;
    private final aj<com.facebook.imagepipeline.g.e> lQL;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.lQK = ajVar;
        this.lQL = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lQK.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes9.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak lQM;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.lQM = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest doX = this.lQM.doX();
            boolean Iv = Iv(i);
            boolean a = ax.a(eVar, doX.dpP());
            if (eVar != null && (a || doX.dpT())) {
                if (Iv && a) {
                    dpj().g(eVar, i);
                } else {
                    dpj().g(eVar, dy(i, 1));
                }
            }
            if (Iv && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.lQL.c(dpj(), this.lQM);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            j.this.lQL.c(dpj(), this.lQM);
        }
    }
}
