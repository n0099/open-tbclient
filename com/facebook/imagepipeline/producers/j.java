package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class j implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> pEk;
    private final aj<com.facebook.imagepipeline.f.e> pEl;

    public j(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        this.pEk = ajVar;
        this.pEl = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pEk.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes5.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private ak pEm;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.pEm = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            ImageRequest eAd = this.pEm.eAd();
            boolean Rf = Rf(i);
            boolean a2 = ax.a(eVar, eAd.eAV());
            if (eVar != null && (a2 || eAd.eAZ())) {
                if (Rf && a2) {
                    eAq().g(eVar, i);
                } else {
                    eAq().g(eVar, ec(i, 1));
                }
            }
            if (Rf && !a2) {
                com.facebook.imagepipeline.f.e.e(eVar);
                j.this.pEl.a(eAq(), this.pEm);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            j.this.pEl.a(eAq(), this.pEm);
        }
    }
}
