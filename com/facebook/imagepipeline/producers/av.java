package com.facebook.imagepipeline.producers;
/* loaded from: classes10.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] lWp;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.lWp = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dq(0, this.lWp.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dqj().dre() == null) {
            kVar.g(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.g(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d lPR;
        private final ak lUF;
        private final int lWq;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.lUF = akVar;
            this.lWq = i;
            this.lPR = this.lUF.dqj().dre();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (IF(i) || ax.a(eVar, this.lPR))) {
                dqv().g(eVar, i);
            } else if (IE(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.lWq + 1, dqv(), this.lUF)) {
                    dqv().g(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            if (!av.this.a(this.lWq + 1, dqv(), this.lUF)) {
                dqv().D(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.dqj().dre());
        if (a2 == -1) {
            return false;
        }
        this.lWp[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.lWp.length) {
            if (!this.lWp[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
