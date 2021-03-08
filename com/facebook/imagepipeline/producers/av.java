package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public class av implements aj<com.facebook.imagepipeline.f.e> {
    private final aw<com.facebook.imagepipeline.f.e>[] pPR;

    public av(aw<com.facebook.imagepipeline.f.e>... awVarArr) {
        this.pPR = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dW(0, this.pPR.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.ezy().eAq() == null) {
            kVar.f(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.f(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.common.d pJx;
        private final ak pOg;
        private final int pPS;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, int i) {
            super(kVar);
            this.pOg = akVar;
            this.pPS = i;
            this.pJx = this.pOg.ezy().eAq();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.imagepipeline.f.e eVar, int i) {
            if (eVar != null && (Qp(i) || ax.a(eVar, this.pJx))) {
                ezL().f(eVar, i);
            } else if (Qo(i)) {
                com.facebook.imagepipeline.f.e.e(eVar);
                if (!av.this.a(this.pPS + 1, ezL(), this.pOg)) {
                    ezL().f(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (!av.this.a(this.pPS + 1, ezL(), this.pOg)) {
                ezL().C(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        int a2 = a(i, akVar.ezy().eAq());
        if (a2 == -1) {
            return false;
        }
        this.pPR[a2].a(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.pPR.length) {
            if (!this.pPR[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
