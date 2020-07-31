package com.facebook.imagepipeline.producers;
/* loaded from: classes4.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] nfR;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.nfR = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.du(0, this.nfR.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dJo().dKi() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d mZs;
        private final ak neg;
        private final int nfS;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.neg = akVar;
            this.nfS = i;
            this.mZs = this.neg.dJo().dKi();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (JI(i) || ax.a(eVar, this.mZs))) {
                dJA().h(eVar, i);
            } else if (JH(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.nfS + 1, dJA(), this.neg)) {
                    dJA().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void E(Throwable th) {
            if (!av.this.a(this.nfS + 1, dJA(), this.neg)) {
                dJA().F(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.dJo().dKi());
        if (a2 == -1) {
            return false;
        }
        this.nfR[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.nfR.length) {
            if (!this.nfR[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
