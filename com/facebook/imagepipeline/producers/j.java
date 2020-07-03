package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> mWa;
    private final aj<com.facebook.imagepipeline.g.e> mWb;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.mWa = ajVar;
        this.mWb = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.mWa.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak mWc;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.mWc = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest dFY = this.mWc.dFY();
            boolean Jm = Jm(i);
            boolean a = ax.a(eVar, dFY.dGS());
            if (eVar != null && (a || dFY.dGW())) {
                if (Jm && a) {
                    dGk().h(eVar, i);
                } else {
                    dGk().h(eVar, dy(i, 1));
                }
            }
            if (Jm && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.mWb.c(dGk(), this.mWc);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            j.this.mWb.c(dGk(), this.mWc);
        }
    }
}
