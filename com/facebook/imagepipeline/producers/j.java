package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> lXd;
    private final aj<com.facebook.imagepipeline.g.e> lXe;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.lXd = ajVar;
        this.lXe = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lXd.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes12.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak lXf;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.lXf = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest drV = this.lXf.drV();
            boolean IP = IP(i);
            boolean a = ax.a(eVar, drV.dsQ());
            if (eVar != null && (a || drV.dsU())) {
                if (IP && a) {
                    dsh().g(eVar, i);
                } else {
                    dsh().g(eVar, dA(i, 1));
                }
            }
            if (IP && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.lXe.c(dsh(), this.lXf);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            j.this.lXe.c(dsh(), this.lXf);
        }
    }
}
