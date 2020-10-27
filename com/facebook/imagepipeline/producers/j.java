package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> oOU;
    private final aj<com.facebook.imagepipeline.g.e> oOV;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.oOU = ajVar;
        this.oOV = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.oOU.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes18.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak oOW;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.oOW = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest enf = this.oOW.enf();
            boolean Pn = Pn(i);
            boolean a2 = ax.a(eVar, enf.enZ());
            if (eVar != null && (a2 || enf.eod())) {
                if (Pn && a2) {
                    enr().h(eVar, i);
                } else {
                    enr().h(eVar, dV(i, 1));
                }
            }
            if (Pn && !a2) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.oOV.c(enr(), this.oOW);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            j.this.oOV.c(enr(), this.oOW);
        }
    }
}
