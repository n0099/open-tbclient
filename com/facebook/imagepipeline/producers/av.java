package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public class av implements aj<com.facebook.imagepipeline.f.e> {
    private final aw<com.facebook.imagepipeline.f.e>[] pFY;

    public av(aw<com.facebook.imagepipeline.f.e>... awVarArr) {
        this.pFY = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dY(0, this.pFY.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.eAd().eAV() == null) {
            kVar.g(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.g(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final ak pEm;
        private final int pFZ;
        private final com.facebook.imagepipeline.common.d pzD;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, int i) {
            super(kVar);
            this.pEm = akVar;
            this.pFZ = i;
            this.pzD = this.pEm.eAd().eAV();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (eVar != null && (Rg(i) || ax.a(eVar, this.pzD))) {
                eAq().g(eVar, i);
            } else if (Rf(i)) {
                com.facebook.imagepipeline.f.e.e(eVar);
                if (!av.this.a(this.pFZ + 1, eAq(), this.pEm)) {
                    eAq().g(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            if (!av.this.a(this.pFZ + 1, eAq(), this.pEm)) {
                eAq().D(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        int a2 = a(i, akVar.eAd().eAV());
        if (a2 == -1) {
            return false;
        }
        this.pFY[a2].a(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.pFY.length) {
            if (!this.pFY[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
