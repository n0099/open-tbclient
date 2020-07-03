package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] mXN;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.mXN = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.ds(0, this.mXN.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dFY().dGS() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d mRi;
        private final ak mWc;
        private final int mXO;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.mWc = akVar;
            this.mXO = i;
            this.mRi = this.mWc.dFY().dGS();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (Jn(i) || ax.a(eVar, this.mRi))) {
                dGk().h(eVar, i);
            } else if (Jm(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.mXO + 1, dGk(), this.mWc)) {
                    dGk().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            if (!av.this.a(this.mXO + 1, dGk(), this.mWc)) {
                dGk().G(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.dFY().dGS());
        if (a2 == -1) {
            return false;
        }
        this.mXN[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.mXN.length) {
            if (!this.mXN[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
