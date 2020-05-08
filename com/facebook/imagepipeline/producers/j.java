package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> meS;
    private final aj<com.facebook.imagepipeline.g.e> meT;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.meS = ajVar;
        this.meT = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.meS.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak meU;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.meU = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest dtQ = this.meU.dtQ();
            boolean Hr = Hr(i);
            boolean a = ax.a(eVar, dtQ.duK());
            if (eVar != null && (a || dtQ.duO())) {
                if (Hr && a) {
                    duc().h(eVar, i);
                } else {
                    duc().h(eVar, dk(i, 1));
                }
            }
            if (Hr && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.meT.c(duc(), this.meU);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            j.this.meT.c(duc(), this.meU);
        }
    }
}
