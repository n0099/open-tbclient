package com.facebook.imagepipeline.producers;
/* loaded from: classes4.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] nfT;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.nfT = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.du(0, this.nfT.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dJp().dKj() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d mZu;
        private final ak nei;
        private final int nfU;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.nei = akVar;
            this.nfU = i;
            this.mZu = this.nei.dJp().dKj();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (JI(i) || ax.a(eVar, this.mZu))) {
                dJB().h(eVar, i);
            } else if (JH(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.nfU + 1, dJB(), this.nei)) {
                    dJB().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void E(Throwable th) {
            if (!av.this.a(this.nfU + 1, dJB(), this.nei)) {
                dJB().F(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.dJp().dKj());
        if (a2 == -1) {
            return false;
        }
        this.nfT[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.nfT.length) {
            if (!this.nfT[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
