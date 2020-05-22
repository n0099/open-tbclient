package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> myJ;
    private final aj<com.facebook.imagepipeline.g.e> myK;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.myJ = ajVar;
        this.myK = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.myJ.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak myL;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.myL = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest dBi = this.myL.dBi();
            boolean Id = Id(i);
            boolean a = ax.a(eVar, dBi.dCc());
            if (eVar != null && (a || dBi.dCg())) {
                if (Id && a) {
                    dBu().h(eVar, i);
                } else {
                    dBu().h(eVar, dp(i, 1));
                }
            }
            if (Id && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.myK.c(dBu(), this.myL);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            j.this.myK.c(dBu(), this.myL);
        }
    }
}
