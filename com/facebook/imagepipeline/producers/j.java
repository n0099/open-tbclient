package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class j implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> poI;
    private final aj<com.facebook.imagepipeline.f.e> poJ;

    public j(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        this.poI = ajVar;
        this.poJ = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.poI.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes15.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private ak poK;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.poK = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.f.e eVar, int i) {
            ImageRequest ewv = this.poK.ewv();
            boolean Rh = Rh(i);
            boolean a2 = ax.a(eVar, ewv.exn());
            if (eVar != null && (a2 || ewv.exr())) {
                if (Rh && a2) {
                    ewI().h(eVar, i);
                } else {
                    ewI().h(eVar, ee(i, 1));
                }
            }
            if (Rh && !a2) {
                com.facebook.imagepipeline.f.e.e(eVar);
                j.this.poJ.a(ewI(), this.poK);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            j.this.poJ.a(ewI(), this.poK);
        }
    }
}
