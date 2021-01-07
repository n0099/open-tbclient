package com.facebook.imagepipeline.producers;
/* loaded from: classes3.dex */
public class av implements aj<com.facebook.imagepipeline.f.e> {
    private final aw<com.facebook.imagepipeline.f.e>[] pHE;

    public av(aw<com.facebook.imagepipeline.f.e>... awVarArr) {
        this.pHE = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dY(0, this.pHE.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.eAH().eBz() == null) {
            kVar.g(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.g(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.common.d pBk;
        private final ak pFT;
        private final int pHF;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, int i) {
            super(kVar);
            this.pFT = akVar;
            this.pHF = i;
            this.pBk = this.pFT.eAH().eBz();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (eVar != null && (Rw(i) || ax.a(eVar, this.pBk))) {
                eAU().g(eVar, i);
            } else if (Rv(i)) {
                com.facebook.imagepipeline.f.e.e(eVar);
                if (!av.this.a(this.pHF + 1, eAU(), this.pFT)) {
                    eAU().g(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            if (!av.this.a(this.pHF + 1, eAU(), this.pFT)) {
                eAU().D(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        int a2 = a(i, akVar.eAH().eBz());
        if (a2 == -1) {
            return false;
        }
        this.pHE[a2].a(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.pHE.length) {
            if (!this.pHE[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
