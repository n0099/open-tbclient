package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes8.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> nyo;
    private final aj<com.facebook.imagepipeline.g.e> nyp;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.nyo = ajVar;
        this.nyp = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.nyo.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes8.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak nyq;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.nyq = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest dVx = this.nyq.dVx();
            boolean Ml = Ml(i);
            boolean a = ax.a(eVar, dVx.dWr());
            if (eVar != null && (a || dVx.dWv())) {
                if (Ml && a) {
                    dVJ().h(eVar, i);
                } else {
                    dVJ().h(eVar, dI(i, 1));
                }
            }
            if (Ml && !a) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.nyp.c(dVJ(), this.nyq);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            j.this.nyp.c(dVJ(), this.nyq);
        }
    }
}
