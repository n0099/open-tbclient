package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes15.dex */
public class j implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> poK;
    private final aj<com.facebook.imagepipeline.f.e> poL;

    public j(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        this.poK = ajVar;
        this.poL = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.poK.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes15.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private ak poM;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.poM = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.f.e eVar, int i) {
            ImageRequest eww = this.poM.eww();
            boolean Rh = Rh(i);
            boolean a2 = ax.a(eVar, eww.exo());
            if (eVar != null && (a2 || eww.exs())) {
                if (Rh && a2) {
                    ewJ().h(eVar, i);
                } else {
                    ewJ().h(eVar, ee(i, 1));
                }
            }
            if (Rh && !a2) {
                com.facebook.imagepipeline.f.e.e(eVar);
                j.this.poL.a(ewJ(), this.poM);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            j.this.poL.a(ewJ(), this.poM);
        }
    }
}
