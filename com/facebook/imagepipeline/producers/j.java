package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> mWd;
    private final aj<com.facebook.imagepipeline.g.e> mWe;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.mWd = ajVar;
        this.mWe = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.mWd.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak mWf;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.mWf = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest dGc = this.mWf.dGc();
            boolean Jm = Jm(i);
            boolean a = ax.a(eVar, dGc.dGW());
            if (eVar != null && (a || dGc.dHa())) {
                if (Jm && a) {
                    dGo().h(eVar, i);
                } else {
                    dGo().h(eVar, dy(i, 1));
                }
            }
            if (Jm && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.mWe.c(dGo(), this.mWf);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            j.this.mWe.c(dGo(), this.mWf);
        }
    }
}
