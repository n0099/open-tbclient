package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public class av implements aj<com.facebook.imagepipeline.f.e> {
    private final aw<com.facebook.imagepipeline.f.e>[] pNM;

    public av(aw<com.facebook.imagepipeline.f.e>... awVarArr) {
        this.pNM = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dW(0, this.pNM.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.ezp().eAh() == null) {
            kVar.g(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.g(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.common.d pHs;
        private final ak pMb;
        private final int pNN;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, int i) {
            super(kVar);
            this.pMb = akVar;
            this.pNN = i;
            this.pHs = this.pMb.ezp().eAh();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (eVar != null && (Ql(i) || ax.a(eVar, this.pHs))) {
                ezC().g(eVar, i);
            } else if (Qk(i)) {
                com.facebook.imagepipeline.f.e.e(eVar);
                if (!av.this.a(this.pNN + 1, ezC(), this.pMb)) {
                    ezC().g(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (!av.this.a(this.pNN + 1, ezC(), this.pMb)) {
                ezC().C(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        int a2 = a(i, akVar.ezp().eAh());
        if (a2 == -1) {
            return false;
        }
        this.pNM[a2].a(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.pNM.length) {
            if (!this.pNM[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
