package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class j implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> pLZ;
    private final aj<com.facebook.imagepipeline.f.e> pMa;

    public j(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        this.pLZ = ajVar;
        this.pMa = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pLZ.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes5.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private ak pMb;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.pMb = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            ImageRequest ezp = this.pMb.ezp();
            boolean Qk = Qk(i);
            boolean a2 = ax.a(eVar, ezp.eAh());
            if (eVar != null && (a2 || ezp.eAl())) {
                if (Qk && a2) {
                    ezC().g(eVar, i);
                } else {
                    ezC().g(eVar, ec(i, 1));
                }
            }
            if (Qk && !a2) {
                com.facebook.imagepipeline.f.e.e(eVar);
                j.this.pMa.a(ezC(), this.pMb);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            j.this.pMa.a(ezC(), this.pMb);
        }
    }
}
