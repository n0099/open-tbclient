package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes3.dex */
public class j implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> pBr;
    private final aj<com.facebook.imagepipeline.f.e> pBs;

    public j(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        this.pBr = ajVar;
        this.pBs = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pBr.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes3.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private ak pBt;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.pBt = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            ImageRequest ewP = this.pBt.ewP();
            boolean PO = PO(i);
            boolean a2 = ax.a(eVar, ewP.exH());
            if (eVar != null && (a2 || ewP.exL())) {
                if (PO && a2) {
                    exc().g(eVar, i);
                } else {
                    exc().g(eVar, ee(i, 1));
                }
            }
            if (PO && !a2) {
                com.facebook.imagepipeline.f.e.e(eVar);
                j.this.pBs.a(exc(), this.pBt);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            j.this.pBs.a(exc(), this.pBt);
        }
    }
}
