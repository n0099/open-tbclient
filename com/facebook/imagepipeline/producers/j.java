package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> mzT;
    private final aj<com.facebook.imagepipeline.g.e> mzU;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.mzT = ajVar;
        this.mzU = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.mzT.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak mzV;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.mzV = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest dBw = this.mzV.dBw();
            boolean If = If(i);
            boolean a = ax.a(eVar, dBw.dCq());
            if (eVar != null && (a || dBw.dCu())) {
                if (If && a) {
                    dBI().h(eVar, i);
                } else {
                    dBI().h(eVar, dp(i, 1));
                }
            }
            if (If && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.mzU.c(dBI(), this.mzV);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            j.this.mzU.c(dBI(), this.mzV);
        }
    }
}
