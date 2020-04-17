package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] mgA;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.mgA = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.de(0, this.mgA.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dtT().duN() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d maa;
        private final ak meQ;
        private final int mgB;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.meQ = akVar;
            this.mgB = i;
            this.maa = this.meQ.dtT().duN();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (Hs(i) || ax.a(eVar, this.maa))) {
                duf().h(eVar, i);
            } else if (Hr(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.mgB + 1, duf(), this.meQ)) {
                    duf().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            if (!av.this.a(this.mgB + 1, duf(), this.meQ)) {
                duf().G(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.dtT().duN());
        if (a2 == -1) {
            return false;
        }
        this.mgA[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.mgA.length) {
            if (!this.mgA[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
