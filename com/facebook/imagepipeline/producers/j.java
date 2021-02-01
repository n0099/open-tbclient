package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class j implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> pLA;
    private final aj<com.facebook.imagepipeline.f.e> pLz;

    public j(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        this.pLz = ajVar;
        this.pLA = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pLz.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes5.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private ak pLB;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.pLB = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            ImageRequest ezh = this.pLB.ezh();
            boolean Qj = Qj(i);
            boolean a2 = ax.a(eVar, ezh.ezZ());
            if (eVar != null && (a2 || ezh.eAd())) {
                if (Qj && a2) {
                    ezu().g(eVar, i);
                } else {
                    ezu().g(eVar, eb(i, 1));
                }
            }
            if (Qj && !a2) {
                com.facebook.imagepipeline.f.e.e(eVar);
                j.this.pLA.a(ezu(), this.pLB);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            j.this.pLA.a(ezu(), this.pLB);
        }
    }
}
