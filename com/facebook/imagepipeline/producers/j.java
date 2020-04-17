package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> meO;
    private final aj<com.facebook.imagepipeline.g.e> meP;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.meO = ajVar;
        this.meP = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.meO.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak meQ;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.meQ = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest dtT = this.meQ.dtT();
            boolean Hr = Hr(i);
            boolean a = ax.a(eVar, dtT.duN());
            if (eVar != null && (a || dtT.duR())) {
                if (Hr && a) {
                    duf().h(eVar, i);
                } else {
                    duf().h(eVar, dk(i, 1));
                }
            }
            if (Hr && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.meP.c(duf(), this.meQ);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            j.this.meP.c(duf(), this.meQ);
        }
    }
}
