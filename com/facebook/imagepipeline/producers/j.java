package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes3.dex */
public class j implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> pFR;
    private final aj<com.facebook.imagepipeline.f.e> pFS;

    public j(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        this.pFR = ajVar;
        this.pFS = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pFR.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes3.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private ak pFT;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.pFT = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            ImageRequest eAH = this.pFT.eAH();
            boolean Rv = Rv(i);
            boolean a2 = ax.a(eVar, eAH.eBz());
            if (eVar != null && (a2 || eAH.eBD())) {
                if (Rv && a2) {
                    eAU().g(eVar, i);
                } else {
                    eAU().g(eVar, ee(i, 1));
                }
            }
            if (Rv && !a2) {
                com.facebook.imagepipeline.f.e.e(eVar);
                j.this.pFS.a(eAU(), this.pFT);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            j.this.pFS.a(eAU(), this.pFT);
        }
    }
}
